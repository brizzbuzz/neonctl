package io.github.unredundant.neonctl.requests

import io.github.unredundant.neonctl.models.EndpointUpdateRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.patch
import io.ktor.client.request.setBody
import kotlin.String

/**
 * Updates the specified endpoint. Currently, only changing the associated branch is supported.
 * The branch that you specify cannot have an existing endpoint.
 *
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain an `endpoint_id` and `branch_id` by listing your project's endpoints.
 * An `endpoint_id` has an `ep-` prefix. A `branch_id` has a `br-` prefix.
 * For more information about endpoints, see [Manage
 * endpoints](https://neon.tech/docs/manage/endpoints/).
 *
 * If the returned list of operations is not empty, the endpoint is not ready to use.
 * The client must wait for the last operation to finish before using the endpoint.
 * If the endpoint was idle before the update, the endpoint becomes active for a short period of
 * time,
 * and the control plane suspends it again after the update.
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.EndpointOperations]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.updateProjectEndpoint(
  body: EndpointUpdateRequest,
  projectId: String,
  endpointId: String,
) = patch("""/projects/$projectId/endpoints/$endpointId""") {
  setBody(body)
}
