package io.github.unredundant.neonctl.models

import kotlinx.serialization.Serializable

@Serializable
public data class RoleResponse(
  public val role: Role,
)
