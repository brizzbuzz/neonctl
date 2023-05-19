package io.github.unredundant.neonctl

import io.github.unredundant.neonctl.models.CreatedBranch
import io.github.unredundant.neonctl.util.NeonCtlUtils
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class SerializationTest : DescribeSpec({
  describe("Serialization") {
    it("Can deserialize a create branch request") {
      // Arrange
      val blob = """
        {
           "branch":{
              "id":"br-damp-brook-365279",
              "project_id":"ancient-art-757350",
              "parent_id":"br-hidden-sun-860403",
              "parent_lsn":"0/414DB48",
              "name":"br-damp-brook-365279",
              "current_state":"init",
              "pending_state":"ready",
              "creation_source":"console",
              "primary":false,
              "cpu_used_sec":0,
              "compute_time_seconds":0,
              "active_time_seconds":0,
              "written_data_bytes":0,
              "data_transfer_bytes":0,
              "created_at":"2023-05-18T22:12:38Z",
              "updated_at":"2023-05-18T22:12:38Z"
           },
           "endpoints":[
              {
                 "host":"ep-late-hall-615764.us-east-2.aws.neon.tech",
                 "id":"ep-late-hall-615764",
                 "project_id":"ancient-art-757350",
                 "branch_id":"br-damp-brook-365279",
                 "autoscaling_limit_min_cu":0.25,
                 "autoscaling_limit_max_cu":0.25,
                 "region_id":"aws-us-east-2",
                 "type":"read_write",
                 "current_state":"init",
                 "pending_state":"active",
                 "settings":{

                 },
                 "pooler_enabled":false,
                 "pooler_mode":"transaction",
                 "disabled":false,
                 "passwordless_access":true,
                 "creation_source":"console",
                 "created_at":"2023-05-18T22:12:38Z",
                 "updated_at":"2023-05-18T22:12:38Z",
                 "proxy_host":"us-east-2.aws.neon.tech",
                 "suspend_timeout_seconds":0,
                 "provisioner":"k8s-pod"
              }
           ],
           "operations":[
              {
                 "id":"f53b9e8b-d623-408c-8e68-b1882a99f0fc",
                 "project_id":"ancient-art-757350",
                 "branch_id":"br-damp-brook-365279",
                 "action":"create_branch",
                 "status":"finished",
                 "failures_count":0,
                 "created_at":"2023-05-18T22:12:38Z",
                 "updated_at":"2023-05-18T22:12:38Z"
              },
              {
                 "id":"41c65841-98a1-4e74-bc2d-a18ee2d1eb86",
                 "project_id":"ancient-art-757350",
                 "branch_id":"br-damp-brook-365279",
                 "endpoint_id":"ep-late-hall-615764",
                 "action":"start_compute",
                 "status":"scheduling",
                 "failures_count":0,
                 "created_at":"2023-05-18T22:12:38Z",
                 "updated_at":"2023-05-18T22:12:38Z"
              }
           ],
           "connection_uris":[
              {
                 "connection_uri":"postgres://unredundant:xdD5AMQEp7Wy@ep-late-hall-615764.us-east-2.aws.neon.tech/portfolio",
                 "connection_parameters":{
                    "database":"portfolio",
                    "password":"xdD5AMQEp7Wy",
                    "role":"unredundant",
                    "host":"ep-late-hall-615764.us-east-2.aws.neon.tech",
                    "pooler_host":"ep-late-hall-615764-pooler.us-east-2.aws.neon.tech"
                 }
              }
           ]
        }
      """.trimIndent()

      // Act
      val result = NeonCtlUtils.json.decodeFromString(CreatedBranch.serializer(), blob)

      // Assert
      result.branch.id shouldBe "br-damp-brook-365279"
      result.endpoints shouldHaveSize 1
      result.connectionUris!! shouldHaveSize 1
    }
  }
})
