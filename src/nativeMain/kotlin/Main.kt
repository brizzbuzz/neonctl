import io.github.unredundant.neonctl.ConfigLoader
import io.ktor.client.request.get
import kotlinx.coroutines.runBlocking

private const val TOKEN = "OMITTED"

fun main() = runBlocking {
//    val client = HttpClientFactory()
//    val result = client.get("api/v2/api_keys")
    val config = ConfigLoader.Impl.getConfig()
    println(config?.token)
}