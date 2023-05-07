package io.github.unredundant.neonctl.models

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class ProjectOperations(
  public val project: Project,
  public val operations: List<Operation>,
)
