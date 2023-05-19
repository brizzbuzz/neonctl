package io.github.unredundant.neonctl.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class BillingSubscriptionType {
  UNKNOWN,
  @SerialName("free")
  FREE,
  @SerialName("pro")
  PRO,
  @SerialName("platform_partnership")
  PLATFORM_PARTNERSHIP,
  @SerialName("enterprise")
  ENTERPRISE,
}
