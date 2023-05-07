package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class PaymentSourceBankCard(
  public val last4: String,
)
