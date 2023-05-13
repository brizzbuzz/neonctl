package io.github.unredundant.neonctl.requests

import io.github.unredundant.neonctl.models.ProjectCreateRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody

/**
 * Creates a Neon project.
 * A project is the top-level object in the Neon object hierarchy.
 * Plan limits define how many projects you can create.
 * Neon's Free plan permits one project per Neon account.
 * For more information, see [Manage projects](https://neon.tech/docs/manage/projects/).
 *
 * You can specify a region and PostgreSQL version in the request body.
 * Neon currently supports PostgreSQL 14 and 15.
 * For supported regions and `region_id` values, see
 * [Regions](https://neon.tech/docs/introduction/regions/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.CreatedProject]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.createProject(body: ProjectCreateRequest) = post("""/projects""") {
  setBody(body)
}
