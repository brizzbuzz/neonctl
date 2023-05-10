package io.github.unredundant.neonctl.commands

import com.github.ajalt.clikt.core.NoOpCliktCommand
import com.github.ajalt.clikt.core.context

/**
 * The entrypoint for the CLI.
 */
object NeonCtlCommand : NoOpCliktCommand() {
    init {
        context { helpOptionNames = setOf("/help") }
    }
}