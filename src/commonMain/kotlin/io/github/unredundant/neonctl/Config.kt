package io.github.unredundant.neonctl

import kotlinx.serialization.Serializable

@Serializable
data class Config(
    val token: String,
)
