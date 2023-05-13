package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import kotlin.String

/**
 * The primary mark is automatically removed from the previous primary branch.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain the `branch_id` by listing the project's branches.
 * For more information, see [Manage branches](https://neon.tech/docs/manage/branches/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.BranchOperations]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.setPrimaryProjectBranch(projectId: String, branchId: String) =
    post("""/projects/$projectId/branches/$branchId/set_as_primary""") {
}
