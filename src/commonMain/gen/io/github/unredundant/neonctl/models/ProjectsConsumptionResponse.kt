package io.github.unredundant.neonctl.models

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class ProjectsConsumptionResponse(
  public val projects: List<ProjectConsumption>,
)
