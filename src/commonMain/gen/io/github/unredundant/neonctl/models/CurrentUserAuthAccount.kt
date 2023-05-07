package io.github.unredundant.neonctl.models

import kotlin.String
import kotlinx.serialization.Serializable

@Serializable
public data class CurrentUserAuthAccount(
  public val email: String,
  public val image: String,
  public val login: String,
  public val name: String,
  public val provider: String,
)
