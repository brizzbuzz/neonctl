package io.github.unredundant.neonctl.models

import kotlinx.serialization.Serializable

@Serializable
public enum class EndpointType {
  READ_ONLY,
  READ_WRITE,
}
