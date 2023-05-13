package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import kotlin.String

/**
 * Retrieves a list of endpoints for the specified branch.
 * Currently, Neon permits only one endpoint per branch.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain the `branch_id` by listing the project's branches.
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.EndpointsResponse]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.listProjectBranchEndpoints(projectId: String, branchId: String) =
    `get`("""/projects/$projectId/branches/$branchId/endpoints""") {
}
