plugins {
  kotlin("multiplatform") version "1.8.21"
  kotlin("plugin.serialization") version "1.8.21"
  id("io.bkbn.skribe") version "0.3.1"
  id("io.kotest.multiplatform") version "5.6.2"
}

object VERSIONS {
  const val KTOR = "2.3.0"
  const val KTX_SERIALIZATION = "1.5.0"
  const val CLIKT = "3.5.2"
  const val KERMIT = "2.0.0-RC4"
  const val YAML_KT = "0.13.0"
  const val OKIO = "3.3.0"
  const val UUID = "0.7.0"
  const val KOTEST = "5.6.2"
}

group = "io.github.unredundant"

repositories {
  mavenCentral()
}

skribe {
  specUrl.set("https://dfv3qgd2ykmrx.cloudfront.net/api_spec/release/v2.json")
  outputDir.set("$projectDir/src/commonMain/gen")
  basePackage.set("io.github.unredundant.neonctl")
  shouldCleanDir.set(true)
}

kotlin {
  jvm {
    jvmToolchain(17)
    withJava()
    testRuns["test"].executionTask.configure {
      useJUnitPlatform()
    }
  }

  val hostOs = System.getProperty("os.name")
  val isMingwX64 = hostOs.startsWith("Windows")
  val nativeTarget = when {
    hostOs == "Mac OS X" -> macosX64("native")
    hostOs == "Linux" -> linuxX64("native")
    isMingwX64 -> mingwX64("native")
    else -> throw GradleException("Host OS is not supported in Kotlin/Native.")
  }

  nativeTarget.apply {
    binaries {
      executable {
        entryPoint = "main"
      }
    }
  }
  sourceSets {
    val commonMain by getting {
      kotlin {
        srcDir("src/commonMain/gen")
      }
      dependencies {
        // Ktor
        implementation("io.ktor:ktor-client-core:${VERSIONS.KTOR}")
        implementation("io.ktor:ktor-client-auth:${VERSIONS.KTOR}")
        implementation("io.ktor:ktor-client-logging:${VERSIONS.KTOR}")
        implementation("io.ktor:ktor-client-content-negotiation:${VERSIONS.KTOR}")
        implementation("io.ktor:ktor-serialization-kotlinx-json:${VERSIONS.KTOR}")

        // Logger
        implementation("co.touchlab:kermit:${VERSIONS.KERMIT}")

        // UUID
        implementation("com.benasher44:uuid:${VERSIONS.UUID}")

        // Serialization
        implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${VERSIONS.KTX_SERIALIZATION}")
        implementation("net.mamoe.yamlkt:yamlkt:${VERSIONS.YAML_KT}")

        // CLI
        implementation("com.github.ajalt.clikt:clikt:${VERSIONS.CLIKT}")

        // IO
        implementation("com.squareup.okio:okio:${VERSIONS.OKIO}")
      }
    }
    val commonTest by getting {
      dependencies {
        implementation("io.kotest:kotest-framework-engine:${VERSIONS.KOTEST}")
        implementation("io.kotest:kotest-assertions-core:${VERSIONS.KOTEST}")
      }
    }
    val nativeMain by getting {
      dependencies {
        implementation("io.ktor:ktor-client-curl:${VERSIONS.KTOR}")
      }
    }
    val nativeTest by getting
    val jvmTest by getting {
      dependencies {
        implementation("io.kotest:kotest-runner-junit5-jvm:${VERSIONS.KOTEST}")
      }
    }
  }
}
