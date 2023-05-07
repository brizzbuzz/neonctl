package io.github.unredundant.neonctl.models

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class DatabasesResponse(
  public val databases: List<Database>,
)
