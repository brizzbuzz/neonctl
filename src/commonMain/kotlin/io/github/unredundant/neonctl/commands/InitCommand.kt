package io.github.unredundant.neonctl.commands

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import io.github.unredundant.neonctl.config.ConfigLoader
import io.github.unredundant.neonctl.config.NeonCtlConfig

class InitCommand(private val configLoader: ConfigLoader) : CliktCommand(help = "Initialize Neonctl") {
    val token by argument(help = "The token used to authenticate to the Neon API")
    override fun run() {
        val config = NeonCtlConfig(token)
        configLoader.saveConfig(config)
        echo("Neonctl initialized. You can now run other commands")
    }
}