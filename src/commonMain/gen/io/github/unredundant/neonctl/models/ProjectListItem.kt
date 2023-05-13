package io.github.unredundant.neonctl.models

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ProjectListItem(
  public val id: String,
  @SerialName("platform_id")
  public val platformId: String,
  @SerialName("region_id")
  public val regionId: String,
  public val name: String,
  public val provisioner: Provisioner,
  @SerialName("default_endpoint_settings")
  public val defaultEndpointSettings: DefaultEndpointSettings?,
  public val settings: ProjectSettingsData?,
  @SerialName("pg_version")
  public val pgVersion: PgVersion,
  @SerialName("proxy_host")
  public val proxyHost: String,
  @SerialName("branch_logical_size_limit")
  public val branchLogicalSizeLimit: Int,
  @SerialName("branch_logical_size_limit_bytes")
  public val branchLogicalSizeLimitBytes: Int,
  @SerialName("store_passwords")
  public val storePasswords: Boolean,
  @SerialName("active_time")
  public val activeTime: Int,
  @SerialName("cpu_used_sec")
  public val cpuUsedSec: Int,
  @SerialName("maintenance_starts_at")
  public val maintenanceStartsAt: String?,
  @SerialName("creation_source")
  public val creationSource: String,
  @SerialName("created_at")
  public val createdAt: String,
  @SerialName("updated_at")
  public val updatedAt: String,
  @SerialName("synthetic_storage_size")
  public val syntheticStorageSize: Int?,
  @SerialName("quota_reset_at")
  public val quotaResetAt: String?,
  @SerialName("owner_id")
  public val ownerId: String,
  public val owner: ProjectOwnerData?,
)
