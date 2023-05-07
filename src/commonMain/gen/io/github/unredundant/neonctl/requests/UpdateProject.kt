package io.github.unredundant.neonctl.requests

import io.github.unredundant.neonctl.models.ProjectUpdateRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.patch
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Updates the specified project.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * Neon permits updating the project name only.
 */
public suspend fun HttpClient.updateProject(requestBody: ProjectUpdateRequest, projectId: String):
    HttpResponse = patch("""/projects/$projectId""") {
  url {
  }
}
