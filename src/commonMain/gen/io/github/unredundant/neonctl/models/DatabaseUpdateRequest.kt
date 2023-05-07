package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DatabaseUpdateRequestDatabase(
  public val name: String,
  @SerialName("owner_name")
  public val ownerName: String,
)

@Serializable
public data class DatabaseUpdateRequest(
  public val database: DatabaseUpdateRequestDatabase,
)
