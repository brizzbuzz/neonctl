package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Retrieves a list of endpoints for the specified project.
 * An endpoint is a Neon compute instance.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * For more information about endpoints, see [Manage
 * endpoints](https://neon.tech/docs/manage/endpoints/).
 */
public suspend fun HttpClient.listProjectEndpoints(projectId: String): HttpResponse =
    `get`("""/projects/$projectId/endpoints""") {
  url {
  }
}
