package io.github.unredundant.neonctl.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
public enum class Provisioner {
  @SerialName("k8s-pod")
  K8S_POD,
  @SerialName("k8s-neonvm")
  K8S_NEONVM,
  @SerialName("docker")
  DOCKER,
}
