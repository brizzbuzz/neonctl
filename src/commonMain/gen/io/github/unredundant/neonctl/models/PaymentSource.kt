package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class PaymentSource(
  public val type: String,
  public val card: PaymentSourceBankCard,
)
