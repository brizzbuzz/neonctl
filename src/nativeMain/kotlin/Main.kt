import co.touchlab.kermit.Logger as KermitLogger
import io.ktor.client.HttpClient
import io.ktor.client.engine.curl.Curl
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking

private const val TOKEN = "OMITTED"

fun main() = runBlocking {
    val client = HttpClient(Curl) {
        install(ContentNegotiation) {
            json()
        }
        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    KermitLogger.v { message }
                }
            }
        }
        install(Auth) {
            bearer {
                loadTokens {
                    BearerTokens(TOKEN, "")
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
    val result = client.get("api/v2/api_keys")
}