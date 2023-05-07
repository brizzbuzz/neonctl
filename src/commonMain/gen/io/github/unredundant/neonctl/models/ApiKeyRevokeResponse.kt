package io.github.unredundant.neonctl.models

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiKeyRevokeResponse(
  public val id: Int,
  public val name: String,
  public val revoked: Boolean,
  @SerialName("last_used_at")
  public val lastUsedAt: String,
  @SerialName("last_used_from_addr")
  public val lastUsedFromAddr: String,
)
