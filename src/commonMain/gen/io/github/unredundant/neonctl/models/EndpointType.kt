package io.github.unredundant.neonctl.models

import kotlinx.serialization.SerialName

public enum class EndpointType {
  @SerialName("read_only")
  READ_ONLY,
  @SerialName("read_write")
  READ_WRITE,
}
