package io.github.unredundant.neonctl.models

import io.github.unredundant.neonctl.util.NumberSerializer
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class BranchCreateRequestEndpointOptions(
  public val type: EndpointType,
  @SerialName("autoscaling_limit_min_cu")
  @Serializable(with = NumberSerializer::class)
  public val autoscalingLimitMinCu: ComputeUnit?,
  @SerialName("autoscaling_limit_max_cu")
  @Serializable(with = NumberSerializer::class)
  public val autoscalingLimitMaxCu: ComputeUnit?,
  public val provisioner: Provisioner?,
  @SerialName("suspend_timeout_seconds")
  public val suspendTimeoutSeconds: SuspendTimeoutSeconds?,
)
