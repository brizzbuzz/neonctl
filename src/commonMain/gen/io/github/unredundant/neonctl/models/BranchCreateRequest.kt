package io.github.unredundant.neonctl.models

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class BranchCreateRequestBranch(
  @SerialName("parent_id")
  public val parentId: String,
  public val name: String,
  @SerialName("parent_lsn")
  public val parentLsn: String,
  @SerialName("parent_timestamp")
  public val parentTimestamp: String,
)

@Serializable
public data class BranchCreateRequest(
  public val endpoints: List<BranchCreateRequestEndpointOptions>,
  public val branch: BranchCreateRequestBranch,
)
