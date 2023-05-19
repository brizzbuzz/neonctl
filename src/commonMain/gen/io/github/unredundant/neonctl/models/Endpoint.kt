package io.github.unredundant.neonctl.models

import io.github.unredundant.neonctl.util.NumberSerializer
import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Endpoint(
  public val host: String,
  public val id: String,
  @SerialName("project_id")
  public val projectId: String,
  @SerialName("branch_id")
  public val branchId: String,
  @SerialName("autoscaling_limit_min_cu")
  @Serializable(with = NumberSerializer::class)
  public val autoscalingLimitMinCu: ComputeUnit,
  @SerialName("autoscaling_limit_max_cu")
  @Serializable(with = NumberSerializer::class)
  public val autoscalingLimitMaxCu: ComputeUnit,
  @SerialName("region_id")
  public val regionId: String,
  public val type: EndpointType,
  @SerialName("current_state")
  public val currentState: EndpointState,
  @SerialName("pending_state")
  public val pendingState: EndpointState?,
  public val settings: EndpointSettingsData,
  @SerialName("pooler_enabled")
  public val poolerEnabled: Boolean,
  @SerialName("pooler_mode")
  public val poolerMode: EndpointPoolerMode,
  public val disabled: Boolean,
  @SerialName("passwordless_access")
  public val passwordlessAccess: Boolean,
  @SerialName("last_active")
  public val lastActive: String?,
  @SerialName("creation_source")
  public val creationSource: String,
  @SerialName("created_at")
  public val createdAt: String,
  @SerialName("updated_at")
  public val updatedAt: String,
  @SerialName("proxy_host")
  public val proxyHost: String,
  @SerialName("suspend_timeout_seconds")
  public val suspendTimeoutSeconds: SuspendTimeoutSeconds,
  public val provisioner: Provisioner,
)
