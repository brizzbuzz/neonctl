package io.github.unredundant.neonctl.util

import kotlinx.serialization.Serializable

@Serializable
data class ErrorMessage(val message: String, val code: Int, val details: String? = null)
