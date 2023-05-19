package io.github.unredundant.neonctl.models

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ConsoleSettingsRaw(
  @SerialName("project_creation_forbidden")
  public val projectCreationForbidden: Boolean?,
  @SerialName("proxy_host")
  public val proxyHost: String?,
)
