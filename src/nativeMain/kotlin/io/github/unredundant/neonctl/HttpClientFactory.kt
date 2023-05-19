package io.github.unredundant.neonctl

import io.github.unredundant.neonctl.config.ConfigLoader
import io.github.unredundant.neonctl.models.CreatedBranch
import io.github.unredundant.neonctl.util.NeonCtlUtils
import io.ktor.client.HttpClient
import io.ktor.client.engine.curl.Curl
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.headers
import io.ktor.http.ContentType
import io.ktor.http.Headers
import io.ktor.http.URLProtocol
import io.ktor.http.contentType
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json

internal object HttpClientFactory {
  operator fun invoke() = HttpClient(Curl) {
    val config = ConfigLoader.Impl.getConfig() ?: error("No config present, must be created prior to client use")
    install(ContentNegotiation) {
      json(NeonCtlUtils.json)
    }
    install(Logging) {
      // Should be None unless debugging
      // todo: make configurable?
      level = LogLevel.NONE
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
      contentType(ContentType.Application.Json)
      url {
        protocol = URLProtocol.HTTPS
        host = "console.neon.tech/api/v2"
        headers {
        }
      }
    }
  }
}
