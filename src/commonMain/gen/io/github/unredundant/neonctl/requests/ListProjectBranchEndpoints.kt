package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Retrieves a list of endpoints for the specified branch.
 * Currently, Neon permits only one endpoint per branch.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain the `branch_id` by listing the project's branches.
 */
public suspend fun HttpClient.listProjectBranchEndpoints(projectId: String, branchId: String):
    HttpResponse = `get`("""/projects/$projectId/branches/$branchId/endpoints""") {
  url {
  }
}
