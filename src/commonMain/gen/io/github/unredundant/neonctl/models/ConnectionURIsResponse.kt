package io.github.unredundant.neonctl.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ConnectionURIsResponse(
  @SerialName("connection_uris")
  public val connectionUris: List<ConnectionDetails>,
)
