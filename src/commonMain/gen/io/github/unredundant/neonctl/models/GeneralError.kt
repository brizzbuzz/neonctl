package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class GeneralError(
  public val code: ErrorCode,
  public val message: String,
)
