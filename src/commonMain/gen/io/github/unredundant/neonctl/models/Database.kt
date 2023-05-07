package io.github.unredundant.neonctl.models

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Database(
  public val id: Int,
  @SerialName("branch_id")
  public val branchId: String,
  public val name: String,
  @SerialName("owner_name")
  public val ownerName: String,
  @SerialName("created_at")
  public val createdAt: String,
  @SerialName("updated_at")
  public val updatedAt: String,
)
