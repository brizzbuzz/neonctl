package io.github.unredundant.neonctl.models

import kotlinx.serialization.SerialName

public enum class OperationAction {
  @SerialName("create_compute")
  CREATE_COMPUTE,
  @SerialName("create_timeline")
  CREATE_TIMELINE,
  @SerialName("start_compute")
  START_COMPUTE,
  @SerialName("suspend_compute")
  SUSPEND_COMPUTE,
  @SerialName("apply_config")
  APPLY_CONFIG,
  @SerialName("check_availability")
  CHECK_AVAILABILITY,
  @SerialName("delete_timeline")
  DELETE_TIMELINE,
  @SerialName("create_branch")
  CREATE_BRANCH,
  @SerialName("tenant_migrate")
  TENANT_MIGRATE,
  @SerialName("tenant_detach")
  TENANT_DETACH,
  @SerialName("tenant_reattach")
  TENANT_REATTACH,
  @SerialName("replace_safekeeper")
  REPLACE_SAFEKEEPER,
}
