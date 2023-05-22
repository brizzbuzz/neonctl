package io.github.unredundant.neonctl.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.findObject
import com.github.ajalt.clikt.parameters.arguments.argument
import io.github.unredundant.neonctl.models.BranchesResponse
import io.github.unredundant.neonctl.models.EndpointsResponse
import io.github.unredundant.neonctl.models.RolePasswordResponse
import io.github.unredundant.neonctl.models.RolesResponse
import io.github.unredundant.neonctl.requests.getProjectBranchRolePassword
import io.github.unredundant.neonctl.requests.listProjectBranchRoles
import io.github.unredundant.neonctl.requests.listProjectBranches
import io.github.unredundant.neonctl.requests.listProjectEndpoints
import io.github.unredundant.neonctl.util.NeonCtlUtils
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import kotlinx.coroutines.runBlocking
import kotlinx.serialization.Serializable

class ProjectCommands(private val client: () -> HttpClient) : CliktCommand(
  name = "project",
  help = "Manage projects"
) {

  private val projectId by argument(help = "The project ID")

  override fun run() {
    currentContext.findOrSetObject {
      ProjectCommandConfig(
        projectId = projectId,
        client = client()
      )
    }
  }

  data class ProjectCommandConfig(
    var projectId: String,
    var client: HttpClient,
  )

  object PrimaryConnectionParametersCommand : CliktCommand(
    help = "Retrieve the connection parameters for the primary branch of the project",
    name = "primary_connection_parameters"
  ) {
    private val config by findObject<ProjectCommandConfig>()

    override fun run() = runBlocking {
      val (projectId, client) = config ?: error("No config found")
      val branches: BranchesResponse = client.listProjectBranches(projectId).body()
      val primaryBranch = branches.branches.find { it.primary } ?: error("No primary branch found")
      val branchRoles: RolesResponse = client.listProjectBranchRoles(projectId, primaryBranch.id).body()
      val endpoints: EndpointsResponse = client.listProjectEndpoints(projectId).body()
      val primaryEndpoint = endpoints.endpoints.find { it.branchId == primaryBranch.id }
        ?: error("No primary endpoint found")
      val primaryRole = branchRoles.roles.find { it.branchId == primaryBranch.id }
        ?: error("No primary role found")
      val password: RolePasswordResponse =
        client.getProjectBranchRolePassword(projectId, primaryBranch.id, primaryRole.name).body()
      val connectionParameters = PrimaryConnectionParameters(
        role = primaryRole.name,
        password = password.password,
        host = primaryEndpoint.host
      )
      echo(NeonCtlUtils.json.encodeToString(PrimaryConnectionParameters.serializer(), connectionParameters))
    }
  }

  @Serializable
  data class PrimaryConnectionParameters(
    val role: String,
    val password: String,
    val host: String,
  )
}
