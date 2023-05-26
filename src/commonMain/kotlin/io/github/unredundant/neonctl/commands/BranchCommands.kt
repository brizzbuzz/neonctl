package io.github.unredundant.neonctl.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.findObject
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import io.github.unredundant.neonctl.models.BranchCreateRequest
import io.github.unredundant.neonctl.models.BranchCreateRequestEndpointOptions
import io.github.unredundant.neonctl.models.BranchesResponse
import io.github.unredundant.neonctl.models.CreatedBranch
import io.github.unredundant.neonctl.models.EndpointType
import io.github.unredundant.neonctl.requests.createProjectBranch
import io.github.unredundant.neonctl.requests.deleteProjectBranch
import io.github.unredundant.neonctl.requests.listProjectBranches
import io.github.unredundant.neonctl.util.ErrorMessage
import io.github.unredundant.neonctl.util.NeonCtlUtils
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import kotlinx.coroutines.runBlocking

class BranchCommands(private val client: () -> HttpClient) : CliktCommand(
  name = "branch",
  help = "Manage branches"
) {

  private val projectId: String by option(
    help = "The project ID",
    names = arrayOf("--project-id", "-p")
  ).required()

  override fun run() {
    currentContext.findOrSetObject {
      BranchCommandConfig(
        projectId = projectId,
        client = client()
      )
    }
  }

  data class BranchCommandConfig(
    var projectId: String,
    var client: HttpClient,
  )

  object CreateBranchCommand : CliktCommand(
    help = "Create a branch",
    name = "create"
  ) {
    private val config by findObject<BranchCommandConfig>()

    private val name by option(
      help = "(Optional) Provide custom name for the branch",
      names = arrayOf("--name", "-n")
    )

    override fun run(): Unit = runBlocking {
      val (projectId, client) = config ?: error("No config found")
      val result = client.createProjectBranch(
        body = BranchCreateRequest(
          endpoints = listOf(
            BranchCreateRequestEndpointOptions(
              type = EndpointType.READ_WRITE,
              autoscalingLimitMinCu = null,
              autoscalingLimitMaxCu = null,
              provisioner = null,
              suspendTimeoutSeconds = null
            )
          ),
          branch = BranchCreateRequest.Branch(
            parentId = null,
            name = name,
            parentLsn = null,
            parentTimestamp = null
          )
        ),
        projectId = projectId,
      )

      when (result.status.value) {
        in 200..299 -> {
          val body: CreatedBranch = result.body()
          echo(NeonCtlUtils.json.encodeToString(CreatedBranch.serializer(), body))
        }

        else -> {
          val body: String = result.body()
          echo(
            NeonCtlUtils.json.encodeToString(
              ErrorMessage.serializer(),
              ErrorMessage(
                message = "Create branch failed",
                code = result.status.value,
                details = body
              )
            )
          )
        }
      }
    }
  }

  object ListBranchesCommand : CliktCommand(
    help = "List branches",
    name = "list"
  ) {
    private val config by findObject<BranchCommandConfig>()
    override fun run(): Unit = runBlocking {
      val (projectId, client) = config ?: error("No config found")
      val result = client.listProjectBranches(projectId)

      when (result.status.value) {
        in 200..299 -> {
          val body: BranchesResponse = result.body()
          echo(NeonCtlUtils.json.encodeToString(BranchesResponse.serializer(), body))
        }

        else -> {
          val body: String = result.body()
          echo(
            NeonCtlUtils.json.encodeToString(
              ErrorMessage.serializer(),
              ErrorMessage(
                message = "List branches failed",
                code = result.status.value,
                details = body
              )
            )
          )
        }
      }
    }
  }

  object DeleteBranchCommand : CliktCommand(
    help = "Delete a branch",
    name = "delete"
  ) {
    private val config by findObject<BranchCommandConfig>()

    private val branchId by option(
      help = "The branch ID (Must be provided if branch name is not provided)",
      names = arrayOf("--branch-id", "-id")
    )

    private val branchName by option(
      help = "The branch name (Must be provided if branch ID is not provided)",
      names = arrayOf("--branch-name", "-n")
    )

    override fun run() = runBlocking {
      require(branchId != null || branchName != null) {
        "Either branch ID or branch name must be provided"
      }

      val (projectId, client) = config ?: error("No config found")

      val branches: BranchesResponse = client.listProjectBranches(projectId).body()
      val branch = branches.branches.find {
        it.id == branchId || it.name == branchName
      } ?: error("Branch not found")

      val result = client.deleteProjectBranch(projectId, branch.id)

      when (result.status.value) {
        in 200..299 -> {
          echo("Branch deleted")
        }

        else -> {
          val body: String = result.body()
          echo(
            NeonCtlUtils.json.encodeToString(
              ErrorMessage.serializer(),
              ErrorMessage(
                message = "Delete branch failed",
                code = result.status.value,
                details = body
              )
            )
          )
        }
      }
    }

  }
}
