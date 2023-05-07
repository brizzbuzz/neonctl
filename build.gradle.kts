plugins {
    kotlin("multiplatform") version "1.8.20"
    kotlin("plugin.serialization") version "1.8.20"
    id("io.bkbn.skribe") version "0.1.1"
}

object VERSIONS {
    const val KTOR = "2.3.0"
    const val KTX_SERIALIZATION = "1.5.0"
    const val KERMIT = "2.0.0-RC4"
}

group = "io.github.unredundant"
version = "0.1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

skribe {
    specUrl.set("https://dfv3qgd2ykmrx.cloudfront.net/api_spec/release/v2.json")
    outputDir.set("$projectDir/src/commonMain/gen")
    basePackage.set("io.github.unredundant.neonctl")
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
                implementation("io.ktor:ktor-client-core:${VERSIONS.KTOR}")
                implementation("io.ktor:ktor-client-cio:${VERSIONS.KTOR}")
                implementation("io.ktor:ktor-client-auth:${VERSIONS.KTOR}")
                implementation("io.ktor:ktor-client-logging:${VERSIONS.KTOR}")
                implementation("io.ktor:ktor-client-content-negotiation:${VERSIONS.KTOR}")
                implementation("io.ktor:ktor-serialization-kotlinx-json:${VERSIONS.KTOR}")
                implementation("co.touchlab:kermit:${VERSIONS.KERMIT}")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${VERSIONS.KTX_SERIALIZATION}")
            }
        }
        val nativeMain by getting
        val nativeTest by getting
    }
}