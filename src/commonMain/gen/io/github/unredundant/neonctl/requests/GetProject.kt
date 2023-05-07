package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Retrieves information about the specified project.
 * A project is the top-level object in the Neon object hierarchy.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 */
public suspend fun HttpClient.getProject(projectId: String): HttpResponse =
    `get`("""/projects/$projectId""") {
  url {
  }
}
