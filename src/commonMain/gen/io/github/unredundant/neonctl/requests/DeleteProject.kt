package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Deletes the specified project.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * Deleting a project is a permanent action.
 * Deleting a project also deletes endpoints, branches, databases, and users that belong to the
 * project.
 */
public suspend fun HttpClient.deleteProject(projectId: String): HttpResponse =
    delete("""/projects/$projectId""") {
  url {
  }
}
