package io.github.unredundant.neonctl.models

import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Branch(
  public val id: String,
  @SerialName("project_id")
  public val projectId: String,
  @SerialName("parent_id")
  public val parentId: String,
  @SerialName("parent_lsn")
  public val parentLsn: String,
  @SerialName("parent_timestamp")
  public val parentTimestamp: String,
  public val name: String,
  @SerialName("current_state")
  public val currentState: BranchState,
  @SerialName("pending_state")
  public val pendingState: BranchState,
  @SerialName("logical_size")
  public val logicalSize: Int,
  @SerialName("creation_source")
  public val creationSource: String,
  public val primary: Boolean,
  @SerialName("cpu_used_sec")
  public val cpuUsedSec: Int,
  @SerialName("compute_time_seconds")
  public val computeTimeSeconds: Int,
  @SerialName("active_time_seconds")
  public val activeTimeSeconds: Int,
  @SerialName("written_data_bytes")
  public val writtenDataBytes: Int,
  @SerialName("data_transfer_bytes")
  public val dataTransferBytes: Int,
  @SerialName("created_at")
  public val createdAt: String,
  @SerialName("updated_at")
  public val updatedAt: String,
)
