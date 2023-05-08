plugins {
    kotlin("multiplatform") version "1.8.20"
    kotlin("plugin.serialization") version "1.8.20"
    id("io.bkbn.skribe") version "0.1.13"
}

object VERSIONS {
    const val KTOR = "2.3.0"
    const val KTX_SERIALIZATION = "1.5.0"
    const val KTX_CLI = "0.3.5"
    const val KERMIT = "2.0.0-RC4"
    const val YAML_KT = "0.13.0"
    const val OKIO = "3.3.0"
}

group = "io.github.unredundant"
version = run {
    val baseVersion =
        project.findProperty("project.version") ?: error("project.version needs to be set in gradle.properties")
    when ((project.findProperty("release") as? String)?.toBoolean()) {
        true -> baseVersion
        else -> "$baseVersion-SNAPSHOT"
    }
}

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
        // val ktorVersion = "2.3.0"
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

                // Serialization
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${VERSIONS.KTX_SERIALIZATION}")
                implementation("net.mamoe.yamlkt:yamlkt:${VERSIONS.YAML_KT}")

                // CLI
                implementation("org.jetbrains.kotlinx:kotlinx-cli:${VERSIONS.KTX_CLI}")

                // IO
                implementation("com.squareup.okio:okio:${VERSIONS.OKIO}")
            }
        }
        val nativeMain by getting {
            dependencies {
                implementation("io.ktor:ktor-client-curl:${VERSIONS.KTOR}")
            }
        }
        val nativeTest by getting
    }
}