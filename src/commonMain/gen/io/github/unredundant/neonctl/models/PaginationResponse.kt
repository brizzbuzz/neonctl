package io.github.unredundant.neonctl.models

import kotlinx.serialization.Serializable

@Serializable
public data class PaginationResponse(
  public val pagination: Pagination?,
)
