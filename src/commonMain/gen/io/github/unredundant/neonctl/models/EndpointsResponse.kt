package io.github.unredundant.neonctl.models

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class EndpointsResponse(
  public val endpoints: List<Endpoint>,
)
