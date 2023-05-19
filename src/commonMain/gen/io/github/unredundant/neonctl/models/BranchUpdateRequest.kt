package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class BranchUpdateRequest(
  public val branch: Branch,
) {
  @Serializable
  public data class Branch(
    public val name: String?,
  )
}
