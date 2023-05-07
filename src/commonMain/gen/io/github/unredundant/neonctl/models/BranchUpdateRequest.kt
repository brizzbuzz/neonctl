package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class BranchUpdateRequestBranch(
  public val name: String,
)

@Serializable
public data class BranchUpdateRequest(
  public val branch: BranchUpdateRequestBranch,
)
