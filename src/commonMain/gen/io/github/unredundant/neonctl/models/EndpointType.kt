package io.github.unredundant.neonctl.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class EndpointType {
  @SerialName("read_only")
  READ_ONLY,
  @SerialName("read_write")
  READ_WRITE,
}
