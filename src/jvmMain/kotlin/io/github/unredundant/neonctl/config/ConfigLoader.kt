package io.github.unredundant.neonctl.config

actual interface ConfigLoader {
    actual fun getConfig(): NeonCtlConfig?
    actual fun saveConfig(neonCtlConfig: NeonCtlConfig)
}