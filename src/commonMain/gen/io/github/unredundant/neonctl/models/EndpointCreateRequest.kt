package io.github.unredundant.neonctl.models

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class EndpointCreateRequestEndpoint(
  @SerialName("branch_id")
  public val branchId: String,
  @SerialName("region_id")
  public val regionId: String,
  public val type: EndpointType,
  public val settings: EndpointSettingsData,
  @SerialName("autoscaling_limit_min_cu")
  public val autoscalingLimitMinCu: ComputeUnit,
  @SerialName("autoscaling_limit_max_cu")
  public val autoscalingLimitMaxCu: ComputeUnit,
  public val provisioner: Provisioner,
  @SerialName("pooler_enabled")
  public val poolerEnabled: Boolean,
  @SerialName("pooler_mode")
  public val poolerMode: EndpointPoolerMode,
  public val disabled: Boolean,
  @SerialName("passwordless_access")
  public val passwordlessAccess: Boolean,
  @SerialName("suspend_timeout_seconds")
  public val suspendTimeoutSeconds: SuspendTimeoutSeconds,
)

@Serializable
public data class EndpointCreateRequest(
  public val endpoint: EndpointCreateRequestEndpoint,
)
