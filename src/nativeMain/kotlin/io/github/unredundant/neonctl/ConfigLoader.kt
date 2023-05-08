package io.github.unredundant.neonctl

import kotlinx.cinterop.toKStringFromUtf8
import net.mamoe.yamlkt.Yaml
import okio.FileSystem
import okio.Path.Companion.toPath
import okio.buffer
import okio.use
import platform.posix.getenv

actual interface ConfigLoader {
    actual fun getConfig(): Config?
    actual fun saveConfig(config: Config)

    object Impl : ConfigLoader {
        override fun getConfig(): Config? {
            if (!fileExists()) return null
            val text = readFileAsText()
            return Yaml.Default.decodeFromString(Config.serializer(), text)
        }

        override fun saveConfig(config: Config) {
            TODO()
        }

        private fun fileExists(): Boolean {
            val home = getenv("HOME")?.toKStringFromUtf8() ?: error("No home directory found")
            val path = "$home.config/neonctl/config.yml".toPath(normalize = true)
            return FileSystem.SYSTEM.exists(path)
        }

        private fun readFileAsText(): String {
            val sb = StringBuilder()
            val home = getenv("HOME")?.toKStringFromUtf8() ?: error("No home directory found")
            val path = "$home.config/neonctl/config.yml".toPath(normalize = true)
            FileSystem.SYSTEM.source(path).use { fileSource ->
                fileSource.buffer().use { bufferedFileSource ->
                    sb.appendLine(bufferedFileSource.readUtf8Line())
                }
            }
            return sb.toString()
        }
    }
}