package io.github.unredundant.neonctl.models

import kotlinx.serialization.Serializable

@Serializable
public data class ProjectResponse(
  public val project: Project,
)
