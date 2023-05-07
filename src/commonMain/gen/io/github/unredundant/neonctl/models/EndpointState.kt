package io.github.unredundant.neonctl.models

import kotlinx.serialization.SerialName

public enum class EndpointState {
  @SerialName("init")
  INIT,
  @SerialName("active")
  ACTIVE,
  @SerialName("idle")
  IDLE,
}
