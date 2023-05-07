import co.touchlab.kermit.Logger as KermitLogger
import io.github.unredundant.neonctl.requests.listProjects
import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.runBlocking

private const val TOKEN = "OMITTED"

fun main() = runBlocking {
    val client = HttpClient(CIO) {
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
                protocol = URLProtocol.HTTPS
                host = "console.neon.tech/api/v2"
            }
        }
    }
    val result = client.listProjects("0", "10")
    print(result.status)
//    val projects: ProjectsResponse = result.body()
}