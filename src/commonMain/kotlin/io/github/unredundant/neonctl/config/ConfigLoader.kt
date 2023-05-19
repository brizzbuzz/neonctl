package io.github.unredundant.neonctl.config

expect interface ConfigLoader {
    fun getConfig(): NeonCtlConfig?
    fun saveConfig(neonCtlConfig: NeonCtlConfig)
}