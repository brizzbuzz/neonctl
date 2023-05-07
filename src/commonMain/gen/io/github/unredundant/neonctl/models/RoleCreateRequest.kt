package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class RoleCreateRequestRole(
  public val name: String,
)

@Serializable
public data class RoleCreateRequest(
  public val role: RoleCreateRequestRole,
)
