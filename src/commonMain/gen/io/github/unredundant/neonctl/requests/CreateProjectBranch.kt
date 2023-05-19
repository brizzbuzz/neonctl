package io.github.unredundant.neonctl.requests

import io.github.unredundant.neonctl.models.BranchCreateRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody
import kotlin.String

/**
 * Creates a branch in the specified project.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 *
 * This method does not require a request body, but you can specify one to create an endpoint for
 * the branch or to select a non-default parent branch.
 * The default behavior is to create a branch from the project's root branch (`main`) with no
 * endpoint, and the branch name is auto-generated.
 * For related information, see [Manage branches](https://neon.tech/docs/manage/branches/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.CreatedBranch]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.createProjectBranch(body: BranchCreateRequest?, projectId: String) =
    post("""/projects/$projectId/branches""") {
  body?.let { setBody(it) }
}
