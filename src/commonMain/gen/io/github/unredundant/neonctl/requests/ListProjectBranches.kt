package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import kotlin.String

/**
 * Retrieves a list of branches for the specified project.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 *
 * Each Neon project has a root branch named `main`.
 * A `branch_id` value has a `br-` prefix.
 * A project may contain child branches that were branched from `main` or from another branch.
 * A parent branch is identified by the `parent_id` value, which is the `id` of the parent branch.
 * For related information, see [Manage branches](https://neon.tech/docs/manage/branches/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.BranchesResponse]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.listProjectBranches(projectId: String) =
    `get`("""/projects/$projectId/branches""") {
}
