package io.github.unredundant.neonctl.models

import kotlinx.serialization.Serializable

@Serializable
public enum class OperationStatus {
  RUNNING,
  FINISHED,
  FAILED,
  SCHEDULING,
}
