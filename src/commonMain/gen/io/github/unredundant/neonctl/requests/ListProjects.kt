package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import kotlin.Int
import kotlin.String

/**
 * Retrieves a list of projects for the Neon account.
 * A project is the top-level object in the Neon object hierarchy.
 * For more information, see [Manage projects](https://neon.tech/docs/manage/projects/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.ListProjects]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.listProjects(cursor: String?, limit: Int?) = `get`("""/projects""") {
  url {
    cursor?.let { parameters.append("cursor", it.toString()) }
    limit?.let { parameters.append("limit", it.toString()) }
  }
}
