package io.github.unredundant.neonctl.models

import kotlinx.serialization.Serializable

@Serializable
public data class EndpointResponse(
  public val endpoint: Endpoint,
)
