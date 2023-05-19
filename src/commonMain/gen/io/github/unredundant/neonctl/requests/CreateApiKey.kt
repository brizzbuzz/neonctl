package io.github.unredundant.neonctl.requests

import io.github.unredundant.neonctl.models.ApiKeyCreateRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.post
import io.ktor.client.request.setBody

/**
 * Creates an API key.
 * The `key_name` is a user-specified name for the key.
 * This method returns an `id` and `key`. The `key` is a randomly generated, 64-bit token required
 * to access the Neon API.
 * API keys can also be managed in the Neon Console.
 * See [Manage API keys](https://neon.tech/docs/manage/api-keys/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.ApiKeyCreateResponse]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.createApiKey(body: ApiKeyCreateRequest) = post("""/api_keys""") {
  setBody(body)
}
