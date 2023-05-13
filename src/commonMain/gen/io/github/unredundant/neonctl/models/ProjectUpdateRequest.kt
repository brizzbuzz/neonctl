package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ProjectUpdateRequest(
  public val project: Project,
) {
  @Serializable
  public data class Project(
    public val settings: ProjectSettingsData?,
    public val name: String?,
    @SerialName("default_endpoint_settings")
    public val defaultEndpointSettings: PgSettingsData?,
  )
}
