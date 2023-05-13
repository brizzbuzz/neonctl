package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import kotlin.String

/**
 * Retrieves a list of databases for the specified branch.
 * A branch can have multiple databases.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain the `branch_id` by listing the project's branches.
 * For related information, see [Manage databases](https://neon.tech/docs/manage/databases/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.DatabasesResponse]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.listProjectBranchDatabases(projectId: String, branchId: String) =
    `get`("""/projects/$projectId/branches/$branchId/databases""") {
}
