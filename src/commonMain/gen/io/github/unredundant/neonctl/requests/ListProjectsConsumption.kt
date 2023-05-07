package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Note, this is a preview API and could be subjected to significant changes in the future.
 * Retrieves a list of per-project consumption for the current billing period.
 */
public suspend fun HttpClient.listProjectsConsumption(cursor: String, limit: String): HttpResponse =
    `get`("""/consumption/projects""") {
  url {
    parameters.append("cursor", cursor)
    parameters.append("limit", limit)
  }
}
