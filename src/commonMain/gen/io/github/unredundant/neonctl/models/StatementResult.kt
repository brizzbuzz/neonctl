package io.github.unredundant.neonctl.models

import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public data class StatementResult(
  public val `data`: StatementData,
  public val error: String,
  @SerialName("explain_data")
  public val explainData: List<ExplainData>,
  public val query: String,
)
