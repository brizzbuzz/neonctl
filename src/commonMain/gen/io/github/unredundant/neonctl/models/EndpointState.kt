package io.github.unredundant.neonctl.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class EndpointState {
  @SerialName("init")
  INIT,
  @SerialName("active")
  ACTIVE,
  @SerialName("idle")
  IDLE,
}
