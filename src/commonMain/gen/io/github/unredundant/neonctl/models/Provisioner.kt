package io.github.unredundant.neonctl.models

import kotlinx.serialization.Serializable

@Serializable
public enum class Provisioner {
  K8S_POD,
  K8S_NEONVM,
  DOCKER,
}
