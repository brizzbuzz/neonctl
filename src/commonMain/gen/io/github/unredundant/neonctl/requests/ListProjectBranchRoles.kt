package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import kotlin.String

/**
 * Retrieves a list of roles from the specified branch.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain the `branch_id` by listing the project's branches.
 * In Neon, the terms "role" and "user" are synonymous.
 * For related information, see [Manage users](https://neon.tech/docs/manage/users/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.RolesResponse]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.listProjectBranchRoles(projectId: String, branchId: String) =
    `get`("""/projects/$projectId/branches/$branchId/roles""") {
}
