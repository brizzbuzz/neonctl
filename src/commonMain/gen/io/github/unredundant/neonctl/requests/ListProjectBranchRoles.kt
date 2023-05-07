package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Retrieves a list of roles from the specified branch.
 * You can obtain a `project_id` by listing the projects for your Neon account.
 * You can obtain the `branch_id` by listing the project's branches.
 * In Neon, the terms "role" and "user" are synonymous.
 * For related information, see [Manage users](https://neon.tech/docs/manage/users/).
 */
public suspend fun HttpClient.listProjectBranchRoles(projectId: String, branchId: String):
    HttpResponse = `get`("""/projects/$projectId/branches/$branchId/roles""") {
  url {
  }
}
