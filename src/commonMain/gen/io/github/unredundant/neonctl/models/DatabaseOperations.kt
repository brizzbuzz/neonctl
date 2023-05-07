package io.github.unredundant.neonctl.models

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class DatabaseOperations(
  public val database: Database,
  public val operations: List<Operation>,
)
