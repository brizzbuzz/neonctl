package io.github.unredundant.neonctl.models

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class Operation(
  public val id: String,
  @SerialName("project_id")
  public val projectId: String,
  @SerialName("branch_id")
  public val branchId: String,
  @SerialName("endpoint_id")
  public val endpointId: String,
  public val action: OperationAction,
  public val status: OperationStatus,
  public val error: String,
  @SerialName("failures_count")
  public val failuresCount: Int,
  @SerialName("retry_at")
  public val retryAt: String,
  @SerialName("created_at")
  public val createdAt: String,
  @SerialName("updated_at")
  public val updatedAt: String,
)
