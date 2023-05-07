package io.github.unredundant.neonctl.models

import kotlinx.serialization.SerialName

public enum class OperationStatus {
  @SerialName("running")
  RUNNING,
  @SerialName("finished")
  FINISHED,
  @SerialName("failed")
  FAILED,
  @SerialName("scheduling")
  SCHEDULING,
}
