package io.github.unredundant.neonctl.models

import kotlinx.serialization.Serializable

@Serializable
public data class OperationResponse(
  public val operation: Operation,
)
