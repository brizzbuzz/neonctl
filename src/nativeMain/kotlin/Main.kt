import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.subcommands
import io.github.unredundant.neonctl.commands.InitCommand
import io.github.unredundant.neonctl.commands.NeonCtlCommand
import io.github.unredundant.neonctl.config.ConfigLoader

fun main(args: Array<String>) = NeonCtlCommand
    .subcommands(
        InitCommand(ConfigLoader.Impl)
    )
    .main(args)

//    val client = io.github.unredundant.neonctl.HttpClientFactory()
//    val result = client.get("api/v2/api_keys")
//    val config = ConfigLoader.Impl.getConfig()
//    println(config?.token)
