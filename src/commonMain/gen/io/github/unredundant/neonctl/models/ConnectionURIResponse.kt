package io.github.unredundant.neonctl.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ConnectionURIResponse(
  @SerialName("connection_uri")
  public val connectionUri: ConnectionDetails,
)
