package io.github.unredundant.neonctl.models

import kotlin.Boolean
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class EndpointUpdateRequest(
  public val endpoint: Endpoint,
) {
  @Serializable
  public data class Endpoint(
    @SerialName("branch_id")
    public val branchId: String?,
    @SerialName("autoscaling_limit_min_cu")
    public val autoscalingLimitMinCu: ComputeUnit?,
    @SerialName("autoscaling_limit_max_cu")
    public val autoscalingLimitMaxCu: ComputeUnit?,
    public val provisioner: Provisioner?,
    public val settings: EndpointSettingsData?,
    @SerialName("pooler_enabled")
    public val poolerEnabled: Boolean?,
    @SerialName("pooler_mode")
    public val poolerMode: EndpointPoolerMode?,
    public val disabled: Boolean?,
    @SerialName("passwordless_access")
    public val passwordlessAccess: Boolean?,
    @SerialName("suspend_timeout_seconds")
    public val suspendTimeoutSeconds: SuspendTimeoutSeconds?,
  )
}
