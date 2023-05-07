package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class ExplainData(
  @SerialName("QUERY PLAN")
  public val QUERY_PLAN: String,
)
