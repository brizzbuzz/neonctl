package io.github.unredundant.neonctl.models

import kotlinx.serialization.SerialName

public enum class Provisioner {
  `k8s-pod`,
  `k8s-neonvm`,
  @SerialName("docker")
  DOCKER,
}
