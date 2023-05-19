package io.github.unredundant.neonctl.config

import kotlinx.serialization.Serializable

@Serializable
data class NeonCtlConfig(
    val token: String,
)