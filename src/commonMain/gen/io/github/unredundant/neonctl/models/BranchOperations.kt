package io.github.unredundant.neonctl.models

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class BranchOperations(
  public val branch: Branch,
  public val operations: List<Operation>,
)
