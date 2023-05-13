package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import kotlin.String

/**
 * Retrieves a list of endpoints for the specified project.
 * An endpoint is a Neon compute instance.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * For more information about endpoints, see [Manage
 * endpoints](https://neon.tech/docs/manage/endpoints/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.EndpointsResponse]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.listProjectEndpoints(projectId: String) =
    `get`("""/projects/$projectId/endpoints""") {
}
