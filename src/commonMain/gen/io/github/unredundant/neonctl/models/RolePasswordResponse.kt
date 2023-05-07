package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class RolePasswordResponse(
  public val password: String,
)
