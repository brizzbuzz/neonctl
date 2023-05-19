package io.github.unredundant.neonctl.models

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class ListProjects(
  public val projects: List<ProjectListItem>,
  public val pagination: Pagination?,
)
