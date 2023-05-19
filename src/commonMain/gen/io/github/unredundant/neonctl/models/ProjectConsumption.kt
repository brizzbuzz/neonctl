package io.github.unredundant.neonctl.models

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ProjectConsumption(
  public val id: String,
  @SerialName("data_storage_bytes_hour")
  public val dataStorageBytesHour: Int,
  @SerialName("synthetic_storage_size")
  public val syntheticStorageSize: Int,
  @SerialName("data_transfer_bytes")
  public val dataTransferBytes: Int,
  @SerialName("written_data_bytes")
  public val writtenDataBytes: Int,
  @SerialName("compute_time_seconds")
  public val computeTimeSeconds: Int,
  @SerialName("active_time_seconds")
  public val activeTimeSeconds: Int,
  @SerialName("updated_at")
  public val updatedAt: String,
)
