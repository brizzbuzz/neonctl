package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import kotlin.String

/**
 * Deletes the specified role from the branch.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain the `branch_id` by listing the project's branches.
 * You can obtain the `role_name` by listing the roles for a branch.
 * In Neon, the terms "role" and "user" are synonymous.
 * For related information, see [Managing users](https://neon.tech/docs/manage/users/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.RoleOperations]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.deleteProjectBranchRole(
  projectId: String,
  branchId: String,
  roleName: String,
) = delete("""/projects/$projectId/branches/$branchId/roles/$roleName""") {
}
