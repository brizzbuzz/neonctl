package io.github.unredundant.neonctl.requests

import io.github.unredundant.neonctl.models.BranchUpdateRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.patch
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Updates the specified branch. Only changing the branch name is supported.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain the `branch_id` by listing the project's branches.
 * For more information, see [Manage branches](https://neon.tech/docs/manage/branches/).
 */
public suspend fun HttpClient.updateProjectBranch(
  requestBody: BranchUpdateRequest,
  projectId: String,
  branchId: String,
): HttpResponse = patch("""/projects/$projectId/branches/$branchId""") {
  url {
  }
}
