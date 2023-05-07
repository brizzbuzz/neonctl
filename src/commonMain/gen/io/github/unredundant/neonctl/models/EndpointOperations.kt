package io.github.unredundant.neonctl.models

import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class EndpointOperations(
  public val endpoint: Endpoint,
  public val operations: List<Operation>,
)
