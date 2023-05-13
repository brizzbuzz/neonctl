package io.github.unredundant.neonctl.models

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class ListProjectsConsumption(
  public val projects: List<ProjectConsumption>,
  public val pagination: Pagination?,
)
