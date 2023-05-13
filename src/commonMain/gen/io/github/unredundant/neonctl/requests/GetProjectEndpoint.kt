package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import kotlin.String

/**
 * Retrieves information about the specified endpoint.
 * An endpoint is a Neon compute instance.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain an `endpoint_id` by listing your project's endpoints.
 * An `endpoint_id` has an `ep-` prefix.
 * For more information about endpoints, see [Manage
 * endpoints](https://neon.tech/docs/manage/endpoints/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.EndpointResponse]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.getProjectEndpoint(projectId: String, endpointId: String) =
    `get`("""/projects/$projectId/endpoints/$endpointId""") {
}
