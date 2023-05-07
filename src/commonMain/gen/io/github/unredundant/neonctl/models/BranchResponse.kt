package io.github.unredundant.neonctl.models

import kotlinx.serialization.Serializable

@Serializable
public data class BranchResponse(
  public val branch: Branch,
)
