package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Retrieves a list of projects for the Neon account.
 * A project is the top-level object in the Neon object hierarchy.
 * For more information, see [Manage projects](https://neon.tech/docs/manage/projects/).
 */
public suspend fun HttpClient.listProjects(cursor: String, limit: String): HttpResponse =
    `get`("""/projects""") {
  url {
    parameters.append("cursor", cursor)
    parameters.append("limit", limit)
  }
}
