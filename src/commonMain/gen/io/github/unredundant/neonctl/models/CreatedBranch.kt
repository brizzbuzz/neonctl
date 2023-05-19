package io.github.unredundant.neonctl.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CreatedBranch(
  public val branch: Branch,
  public val endpoints: List<Endpoint>,
  public val operations: List<Operation>,
  @SerialName("connection_uris")
  public val connectionUris: List<ConnectionDetails>?,
)
