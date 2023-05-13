package io.github.unredundant.neonctl.models

import kotlinx.serialization.Serializable

@Serializable
public enum class BillingSubscriptionType {
  UNKNOWN,
  FREE,
  PRO,
  PLATFORM_PARTNERSHIP,
  ENTERPRISE,
}
