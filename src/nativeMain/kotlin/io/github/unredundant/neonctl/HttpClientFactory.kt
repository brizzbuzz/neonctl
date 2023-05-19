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

fun main() {
    val blob = """
        {
           "branch":{
              "id":"br-tight-sound-452188",
              "project_id":"ancient-art-757350",
              "parent_id":"br-hidden-sun-860403",
              "parent_lsn":"0/414DB48",
              "name":"br-tight-sound-452188",
              "current_state":"init",
              "pending_state":"ready",
              "creation_source":"console",
              "primary":false,
              "cpu_used_sec":0,
              "compute_time_seconds":0,
              "active_time_seconds":0,
              "written_data_bytes":0,
              "data_transfer_bytes":0,
              "created_at":"2023-05-18T20:32:53Z",
              "updated_at":"2023-05-18T20:32:53Z"
           },
           "endpoints":[
              
           ],
           "operations":[
              {
                 "id":"5ad21847-bd62-4bf5-b16e-eba55ccfabe8",
                 "project_id":"ancient-art-757350",
                 "branch_id":"br-tight-sound-452188",
                 "action":"create_branch",
                 "status":"finished",
                 "failures_count":0,
                 "created_at":"2023-05-18T20:32:53Z",
                 "updated_at":"2023-05-18T20:32:53Z"
              }
           ]
        }
    """.trimIndent()
    val result = NeonCtlUtils.json.decodeFromString(CreatedBranch.serializer(), blob)
    print(result)
}