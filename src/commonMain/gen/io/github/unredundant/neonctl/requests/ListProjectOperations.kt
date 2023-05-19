package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import kotlin.Int
import kotlin.String

/**
 * Retrieves a list of operations for the specified Neon project.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * The number of operations returned can be large.
 * To paginate the response, issue an initial request with a `limit` value.
 * Then, add the `cursor` value that was returned in the response to the next request.
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.ListOperations]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.listProjectOperations(
  cursor: String?,
  limit: Int?,
  projectId: String,
) = `get`("""/projects/$projectId/operations""") {
  url {
    cursor?.let { parameters.append("cursor", it.toString()) }
    limit?.let { parameters.append("limit", it.toString()) }
  }
}
