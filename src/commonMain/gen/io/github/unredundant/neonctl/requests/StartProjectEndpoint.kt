package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.post
import kotlin.String

/**
 * Starts an endpoint. The endpoint is ready to use
 * after the last operation in chain finishes successfully.
 *
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain an `endpoint_id` by listing your project's endpoints.
 * An `endpoint_id` has an `ep-` prefix.
 * For more information about endpoints, see [Manage
 * endpoints](https://neon.tech/docs/manage/endpoints/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.EndpointOperations]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.startProjectEndpoint(projectId: String, endpointId: String) =
    post("""/projects/$projectId/endpoints/$endpointId/start""") {
}
