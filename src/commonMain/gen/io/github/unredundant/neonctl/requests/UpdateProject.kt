package io.github.unredundant.neonctl.requests

import io.github.unredundant.neonctl.models.ProjectUpdateRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.patch
import io.ktor.client.request.setBody
import kotlin.String

/**
 * Updates the specified project.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * Neon permits updating the project name only.
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.ProjectOperations]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.updateProject(body: ProjectUpdateRequest, projectId: String) =
    patch("""/projects/$projectId""") {
  setBody(body)
}
