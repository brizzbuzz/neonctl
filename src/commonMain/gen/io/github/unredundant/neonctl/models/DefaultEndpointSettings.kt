package io.github.unredundant.neonctl.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DefaultEndpointSettings(
  @SerialName("pg_settings")
  public val pgSettings: PgSettingsData?,
)
