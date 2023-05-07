package io.github.unredundant.neonctl.models

import kotlin.Boolean
import kotlin.String
import kotlin.collections.List
import kotlinx.serialization.Serializable

@Serializable
public data class StatementData(
  public val fields: List<String>,
  public val rows: List<List<String>>,
  public val truncated: Boolean,
)
