package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Retrieves details for the specified operation.
 * An operation is an action performed on a Neon project resource.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain a `operation_id` by listing operations for the project.
 */
public suspend fun HttpClient.getProjectOperation(projectId: String, operationId: String):
    HttpResponse = `get`("""/projects/$projectId/operations/$operationId""") {
  url {
  }
}
