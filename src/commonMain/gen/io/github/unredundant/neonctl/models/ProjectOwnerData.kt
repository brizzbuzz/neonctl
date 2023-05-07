package io.github.unredundant.neonctl.models

import kotlin.Int
import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ProjectOwnerData(
  public val email: String,
  @SerialName("branches_limit")
  public val branchesLimit: Int,
  @SerialName("subscription_type")
  public val subscriptionType: BillingSubscriptionType,
)
