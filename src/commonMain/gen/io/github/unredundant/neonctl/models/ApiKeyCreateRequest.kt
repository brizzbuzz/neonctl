package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiKeyCreateRequest(
  @SerialName("key_name")
  public val keyName: String,
)
