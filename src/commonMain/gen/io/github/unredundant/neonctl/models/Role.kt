package io.github.unredundant.neonctl.models

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Role(
  @SerialName("branch_id")
  public val branchId: String,
  public val name: String,
  public val password: String?,
  public val `protected`: Boolean?,
  @SerialName("created_at")
  public val createdAt: String,
  @SerialName("updated_at")
  public val updatedAt: String,
)
