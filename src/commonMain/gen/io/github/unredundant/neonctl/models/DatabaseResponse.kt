package io.github.unredundant.neonctl.models

import kotlinx.serialization.Serializable

@Serializable
public data class DatabaseResponse(
  public val database: Database,
)
