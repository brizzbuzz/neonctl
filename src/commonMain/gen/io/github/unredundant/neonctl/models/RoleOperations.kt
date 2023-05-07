package io.github.unredundant.neonctl.models

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class RoleOperations(
  public val role: Role,
  public val operations: List<Operation>,
)
