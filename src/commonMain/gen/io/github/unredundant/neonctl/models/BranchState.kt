package io.github.unredundant.neonctl.models

import kotlinx.serialization.SerialName

public enum class BranchState {
  @SerialName("init")
  INIT,
  @SerialName("ready")
  READY,
}
