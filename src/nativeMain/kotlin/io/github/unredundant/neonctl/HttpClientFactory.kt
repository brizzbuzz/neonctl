package io.github.unredundant.neonctl

import io.github.unredundant.neonctl.config.ConfigLoader
import io.ktor.client.HttpClient
import io.ktor.client.engine.curl.Curl
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json

object HttpClientFactory {
    operator fun invoke() = HttpClient(Curl) {
        val config = ConfigLoader.Impl.getConfig() ?: error("No config present, must be created prior to client use")
        install(ContentNegotiation) {
            json()
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    co.touchlab.kermit.Logger.v { message }
                }
            }
        }
        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(config.token, "")
                }
            }
        }
        defaultRequest {
            url {
                protocol = URLProtocol.HTTP
                host = "console.neon.tech"
            }
        }
    }
}