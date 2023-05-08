import io.github.unredundant.neonctl.ConfigLoader
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
//    val client = io.github.unredundant.neonctl.HttpClientFactory()
//    val result = client.get("api/v2/api_keys")
    val config = ConfigLoader.Impl.getConfig()
    println(config?.token)
}