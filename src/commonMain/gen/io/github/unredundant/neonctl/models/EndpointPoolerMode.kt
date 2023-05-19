package io.github.unredundant.neonctl.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class EndpointPoolerMode {
  @SerialName("transaction")
  TRANSACTION,
}
