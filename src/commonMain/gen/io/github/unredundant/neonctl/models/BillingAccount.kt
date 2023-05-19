package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class BillingAccount(
  @SerialName("payment_source")
  public val paymentSource: PaymentSource,
  @SerialName("subscription_type")
  public val subscriptionType: BillingSubscriptionType,
  @SerialName("quota_reset_at_last")
  public val quotaResetAtLast: String,
  public val email: String,
  @SerialName("address_city")
  public val addressCity: String,
  @SerialName("address_country")
  public val addressCountry: String,
  @SerialName("address_line1")
  public val addressLine1: String,
  @SerialName("address_line2")
  public val addressLine2: String,
  @SerialName("address_postal_code")
  public val addressPostalCode: String,
  @SerialName("address_state")
  public val addressState: String,
)
