package io.github.unredundant.neonctl.models

import kotlin.Int
import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class ApiKeyCreateResponse(
  public val id: Int,
  public val key: String,
)
