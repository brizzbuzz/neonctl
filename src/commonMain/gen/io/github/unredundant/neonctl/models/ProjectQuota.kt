package io.github.unredundant.neonctl.models

import kotlin.Int
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ProjectQuota(
  @SerialName("active_time_seconds")
  public val activeTimeSeconds: Int,
  @SerialName("compute_time_seconds")
  public val computeTimeSeconds: Int,
  @SerialName("written_data_bytes")
  public val writtenDataBytes: Int,
  @SerialName("data_transfer_bytes")
  public val dataTransferBytes: Int,
  @SerialName("logical_size_bytes")
  public val logicalSizeBytes: Int,
)
