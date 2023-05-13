package io.github.unredundant.neonctl.models

import kotlinx.serialization.Serializable

@Serializable
public enum class BranchState {
  INIT,
  READY,
}
