package io.github.unredundant.neonctl.models

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ApiKeysListResponseItem(
  public val id: Int,
  public val name: String,
  @SerialName("created_at")
  public val createdAt: String,
  @SerialName("last_used_at")
  public val lastUsedAt: String,
  @SerialName("last_used_from_addr")
  public val lastUsedFromAddr: String,
)
