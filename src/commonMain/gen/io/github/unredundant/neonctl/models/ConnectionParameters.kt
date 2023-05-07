package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ConnectionParameters(
  public val database: String,
  public val password: String,
  public val role: String,
  public val host: String,
  @SerialName("pooler_host")
  public val poolerHost: String,
)
