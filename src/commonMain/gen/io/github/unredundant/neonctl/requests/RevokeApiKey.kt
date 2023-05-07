package io.github.unredundant.neonctl.requests

import io.ktor.client.HttpClient
import io.ktor.client.request.delete
import io.ktor.client.statement.HttpResponse
import kotlin.String

/**
 * Revokes the specified API key.
 * An API key that is no longer needed can be revoked.
 * This action cannot be reversed.
 * You can obtain `key_id` values by listing the API keys for your Neon account.
 * API keys can also be managed in the Neon Console.
 * See [Manage API keys](https://neon.tech/docs/manage/api-keys/).
 */
public suspend fun HttpClient.revokeApiKey(keyId: String): HttpResponse =
    delete("""/api_keys/$keyId""") {
  url {
  }
}
