package io.github.unredundant.neonctl.models

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class ListOperations(
  public val operations: List<Operation>,
  public val pagination: Pagination?,
)
