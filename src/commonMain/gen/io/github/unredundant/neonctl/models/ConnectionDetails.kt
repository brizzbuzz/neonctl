package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ConnectionDetails(
  @SerialName("connection_uri")
  public val connectionUri: String,
  @SerialName("connection_parameters")
  public val connectionParameters: ConnectionParameters,
)
