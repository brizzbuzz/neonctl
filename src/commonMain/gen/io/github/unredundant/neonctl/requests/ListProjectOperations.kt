package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Retrieves a list of operations for the specified Neon project.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * The number of operations returned can be large.
 * To paginate the response, issue an initial request with a `limit` value.
 * Then, add the `cursor` value that was returned in the response to the next request.
 */
public suspend fun HttpClient.listProjectOperations(
  cursor: String,
  limit: String,
  projectId: String,
): HttpResponse = `get`("""/projects/$projectId/operations""") {
  url {
    parameters.append("cursor", cursor)
    parameters.append("limit", limit)
  }
}
