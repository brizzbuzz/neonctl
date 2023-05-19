package io.github.unredundant.neonctl.models

import io.github.unredundant.neonctl.util.NumberSerializer
import kotlin.Int
import kotlin.Number
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ProjectLimits(
  public val limits: Limits,
) {
  @Serializable
  public data class Limits(
    @SerialName("active_time")
    public val activeTime: Int,
    @SerialName("max_projects")
    public val maxProjects: Int,
    @SerialName("max_branches")
    public val maxBranches: Int,
    @SerialName("max_autoscaling_cu")
    @Serializable(with = NumberSerializer::class)
    public val maxAutoscalingCu: Number,
    @SerialName("cpu_seconds")
    public val cpuSeconds: Int,
    @SerialName("max_active_endpoints")
    public val maxActiveEndpoints: Int,
  )
}
