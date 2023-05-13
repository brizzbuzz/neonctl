package io.github.unredundant.neonctl.models

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ProjectCreateRequest(
  public val project: Project,
) {
  @Serializable
  public data class Project(
    public val settings: ProjectSettingsData?,
    public val name: String?,
    public val branch: Branch?,
    @SerialName("autoscaling_limit_min_cu")
    public val autoscalingLimitMinCu: ComputeUnit?,
    @SerialName("autoscaling_limit_max_cu")
    public val autoscalingLimitMaxCu: ComputeUnit?,
    public val provisioner: Provisioner?,
    @SerialName("region_id")
    public val regionId: String?,
    @SerialName("default_endpoint_settings")
    public val defaultEndpointSettings: PgSettingsData?,
    @SerialName("pg_version")
    public val pgVersion: PgVersion?,
    @SerialName("store_passwords")
    public val storePasswords: Boolean?,
  ) {
    @Serializable
    public data class Branch(
      public val name: String?,
      @SerialName("role_name")
      public val roleName: String?,
      @SerialName("database_name")
      public val databaseName: String?,
    )
  }
}
