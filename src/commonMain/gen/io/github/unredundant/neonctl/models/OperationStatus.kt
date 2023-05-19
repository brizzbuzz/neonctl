package io.github.unredundant.neonctl.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
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
