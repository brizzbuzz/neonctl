package io.github.unredundant.neonctl.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.NoOpCliktCommand
import com.github.ajalt.clikt.core.findObject
import com.github.ajalt.clikt.core.findOrSetObject
import com.github.ajalt.clikt.core.requireObject
import com.github.ajalt.clikt.parameters.options.option
import com.github.ajalt.clikt.parameters.options.required
import io.github.unredundant.neonctl.models.BranchCreateRequest
import io.github.unredundant.neonctl.requests.createProjectBranch
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import kotlinx.coroutines.runBlocking

class BranchCommands(private val client: () -> HttpClient) : CliktCommand(
    name = "branch",
    help = "Manage branches"
) {

    private val projectId: String by option(
        help = "The project ID to create the branch in",
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
        override fun run(): Unit = runBlocking {
            val (projectId, client) = config ?: error("No config found")
            val result = client.createProjectBranch(projectId)
            val body: BranchCreateRequest = result.body()
            echo(body)
        }
    }

    object ListBranchesCommand : CliktCommand(
        help = "List branches",
        name = "list"
    ) {
        private val config by findObject<BranchCommandConfig>()
        override fun run() {
            echo("List branches")
        }
    }
}