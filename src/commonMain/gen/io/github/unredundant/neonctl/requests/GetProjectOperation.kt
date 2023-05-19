package io.github.unredundant.neonctl.requests

import com.benasher44.uuid.Uuid
import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import kotlin.String

/**
 * Retrieves details for the specified operation.
 * An operation is an action performed on a Neon project resource.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain a `operation_id` by listing operations for the project.
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.OperationResponse]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.getProjectOperation(projectId: String, operationId: Uuid) =
    `get`("""/projects/$projectId/operations/$operationId""") {
}
