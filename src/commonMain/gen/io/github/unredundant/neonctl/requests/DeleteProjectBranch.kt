package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Deletes the specified branch from a project, and places
 * all endpoints into an idle state, breaking existing client connections.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain a `branch_id` by listing the project's branches.
 * For related information, see [Manage branches](https://neon.tech/docs/manage/branches/).
 *
 * When a successful response status is received, the endpoints are still active,
 * and the branch is not yet deleted from storage.
 * The deletion occurs after all operations finish.
 * You cannot delete a branch if it is the only remaining branch in the project.
 * A project must have at least one branch.
 */
public suspend fun HttpClient.deleteProjectBranch(projectId: String, branchId: String): HttpResponse
    = delete("""/projects/$projectId/branches/$branchId""") {
  url {
  }
}
