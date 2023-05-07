package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class EndpointPasswordlessSessionAuthRequest(
  @SerialName("session_id")
  public val sessionId: String,
)
