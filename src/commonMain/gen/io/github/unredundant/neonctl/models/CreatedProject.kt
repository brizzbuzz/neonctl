package io.github.unredundant.neonctl.models

import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CreatedProject(
  public val project: Project,
  @SerialName("connection_uris")
  public val connectionUris: List<ConnectionDetails>,
  public val roles: List<Role>,
  public val databases: List<Database>,
  public val operations: List<Operation>,
  public val branch: Branch,
  public val endpoints: List<Endpoint>,
)
