package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.`get`

/**
 * Retrieves the API keys for your Neon account.
 * The response does not include API key tokens. A token is only provided when creating an API key.
 * API keys can also be managed in the Neon Console.
 * For more information, see [Manage API keys](https://neon.tech/docs/manage/api-keys/).
 * Body can be one of the following types:
 * 	- [kotlin.collections.List<io.github.unredundant.neonctl.models.ApiKeysListResponseItem>]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.listApiKeys() = `get`("""/api_keys""") {
}
