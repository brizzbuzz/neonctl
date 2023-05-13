package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import kotlin.Int
import kotlin.String

/**
 * Note, this is a preview API and could be subjected to significant changes in the future.
 * Retrieves a list of per-project consumption for the current billing period.
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.ListProjectsConsumption]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.listProjectsConsumption(cursor: String?, limit: Int?) =
    `get`("""/consumption/projects""") {
  url {
    cursor?.let { parameters.append("cursor", it.toString()) }
    limit?.let { parameters.append("limit", it.toString()) }
  }
}
