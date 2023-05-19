package io.github.unredundant.neonctl.requests

import io.github.unredundant.neonctl.models.DatabaseCreateRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import kotlin.String

/**
 * Creates a database in the specified branch.
 * A branch can have multiple databases.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain the `branch_id` by listing the project's branches.
 * For related information, see [Manage databases](https://neon.tech/docs/manage/databases/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.DatabaseOperations]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.createProjectBranchDatabase(
  body: DatabaseCreateRequest,
  projectId: String,
  branchId: String,
) = post("""/projects/$projectId/branches/$branchId/databases""") {
  setBody(body)
}
