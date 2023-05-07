package io.github.unredundant.neonctl.requests

import io.github.unredundant.neonctl.models.EndpointCreateRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Creates an endpoint for the specified branch.
 * An endpoint is a Neon compute instance.
 * There is a maximum of one endpoint per branch.
 * If the specified branch already has an endpoint, the operation fails.
 *
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain `branch_id` by listing the project's branches.
 * A `branch_id` has a `br-` prefix.
 * Currently, only the `read_write` endpoint type is supported.
 * For supported regions and `region_id` values, see
 * [Regions](https://neon.tech/docs/introduction/regions/).
 * For more information about endpoints, see [Manage
 * endpoints](https://neon.tech/docs/manage/endpoints/).
 */
public suspend fun HttpClient.createProjectEndpoint(requestBody: EndpointCreateRequest,
    projectId: String): HttpResponse = post("""/projects/$projectId/endpoints""") {
  url {
  }
}
