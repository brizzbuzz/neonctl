package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import kotlin.String

/**
 * Retrieves information about the specified project.
 * A project is the top-level object in the Neon object hierarchy.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.ProjectResponse]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.getProject(projectId: String) = `get`("""/projects/$projectId""") {
}
