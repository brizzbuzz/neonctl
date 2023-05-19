package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import kotlin.String

/**
 * Retrieves information about the specified branch.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain a `branch_id` by listing the project's branches.
 * A `branch_id` value has a `br-` prefix.
 *
 * Each Neon project has a root branch named `main`.
 * A project may contain child branches that were branched from `main` or from another branch.
 * A parent branch is identified by a `parent_id` value, which is the `id` of the parent branch.
 * For related information, see [Manage branches](https://neon.tech/docs/manage/branches/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.BranchResponse]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.getProjectBranch(projectId: String, branchId: String) =
    `get`("""/projects/$projectId/branches/$branchId""") {
}
