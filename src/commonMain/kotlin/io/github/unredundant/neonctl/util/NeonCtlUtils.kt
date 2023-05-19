package io.github.unredundant.neonctl.util

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json

object NeonCtlUtils {
    @OptIn(ExperimentalSerializationApi::class)
    val json = Json {
        explicitNulls = false
        ignoreUnknownKeys = true
        isLenient = true
        prettyPrint = true
    }
}
