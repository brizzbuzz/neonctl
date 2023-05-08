package io.github.unredundant.neonctl

expect interface ConfigLoader {
    fun getConfig(): Config?
    fun saveConfig(config: Config)
}