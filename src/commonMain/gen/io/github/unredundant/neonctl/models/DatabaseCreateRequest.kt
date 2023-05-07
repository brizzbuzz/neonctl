package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class DatabaseCreateRequestDatabase(
  public val name: String,
  @SerialName("owner_name")
  public val ownerName: String,
)

@Serializable
public data class DatabaseCreateRequest(
  public val database: DatabaseCreateRequestDatabase,
)
