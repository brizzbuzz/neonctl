package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class RoleCreateRequest(
  public val role: Role,
) {
  @Serializable
  public data class Role(
    public val name: String,
  )
}
