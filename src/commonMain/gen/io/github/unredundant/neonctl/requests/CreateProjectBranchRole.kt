package io.github.unredundant.neonctl.requests

import io.github.unredundant.neonctl.models.RoleCreateRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import kotlin.String

/**
 * Creates a role in the specified branch.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain the `branch_id` by listing the project's branches.
 * In Neon, the terms "role" and "user" are synonymous.
 * For related information, see [Manage users](https://neon.tech/docs/manage/users/).
 *
 * Connections established to the active read-write endpoint will be dropped.
 * If the read-write endpoint is idle, the endpoint becomes active for a short period of time and is
 * suspended afterward.
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.RoleOperations]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.createProjectBranchRole(
  body: RoleCreateRequest,
  projectId: String,
  branchId: String,
) = post("""/projects/$projectId/branches/$branchId/roles""") {
  setBody(body)
}
