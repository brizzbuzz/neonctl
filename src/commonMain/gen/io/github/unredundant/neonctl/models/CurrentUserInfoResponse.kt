package io.github.unredundant.neonctl.models

import kotlin.Int
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class CurrentUserInfoResponse(
  @SerialName("active_seconds_limit")
  public val activeSecondsLimit: Int,
  @SerialName("billing_account")
  public val billingAccount: BillingAccount,
  @SerialName("auth_accounts")
  public val authAccounts: List<CurrentUserAuthAccount>,
  public val email: String,
  public val id: String,
  public val image: String,
  public val login: String,
  public val name: String,
  @SerialName("projects_limit")
  public val projectsLimit: Int,
  @SerialName("branches_limit")
  public val branchesLimit: Int,
  @SerialName("max_autoscaling_limit")
  public val maxAutoscalingLimit: ComputeUnit,
  @SerialName("compute_seconds_limit")
  public val computeSecondsLimit: Int?,
  public val plan: String,
)
