package io.github.unredundant.neonctl.models

import kotlinx.serialization.Serializable

@Serializable
public enum class OperationAction {
  CREATE_COMPUTE,
  CREATE_TIMELINE,
  START_COMPUTE,
  SUSPEND_COMPUTE,
  APPLY_CONFIG,
  CHECK_AVAILABILITY,
  DELETE_TIMELINE,
  CREATE_BRANCH,
  TENANT_MIGRATE,
  TENANT_DETACH,
  TENANT_REATTACH,
  REPLACE_SAFEKEEPER,
}
