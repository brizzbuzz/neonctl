package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Resets the password for the specified role.
 * Returns a new password and operations. The new password is ready to use when the last operation
 * finishes.
 * The old password remains valid until last operation finishes.
 * Connections to the read-write endpoint are dropped. If idle,
 * the read-write endpoint becomes active for a short period of time.
 *
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain the `branch_id` by listing the project's branches.
 * You can obtain the `role_name` by listing the roles for a branch.
 * In Neon, the terms "role" and "user" are synonymous.
 * For related information, see [Managing users](https://neon.tech/docs/manage/users/).
 */
public suspend fun HttpClient.resetProjectBranchRolePassword(
  projectId: String,
  branchId: String,
  roleName: String,
): HttpResponse =
    post("""/projects/$projectId/branches/$branchId/roles/$roleName/reset_password""") {
  url {
  }
}
