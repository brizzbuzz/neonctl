package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import kotlin.String

/**
 * Deletes the specified project.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * Deleting a project is a permanent action.
 * Deleting a project also deletes endpoints, branches, databases, and users that belong to the
 * project.
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.ProjectResponse]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.deleteProject(projectId: String) =
    delete("""/projects/$projectId""") {
}
