package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import kotlin.Int

/**
 * Revokes the specified API key.
 * An API key that is no longer needed can be revoked.
 * This action cannot be reversed.
 * You can obtain `key_id` values by listing the API keys for your Neon account.
 * API keys can also be managed in the Neon Console.
 * See [Manage API keys](https://neon.tech/docs/manage/api-keys/).
 * Body can be one of the following types:
 * 	- [io.github.unredundant.neonctl.models.ApiKeyRevokeResponse]
 * 	- [io.github.unredundant.neonctl.models.GeneralError]
 */
public suspend fun HttpClient.revokeApiKey(keyId: Int) = delete("""/api_keys/$keyId""") {
}
