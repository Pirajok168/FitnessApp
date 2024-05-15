import org.jetbrains.kotlin.gradle.plugin.mpp.Framework.BitcodeEmbeddingMode


plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
}

kotlin {
    applyDefaultHierarchyTemplate()
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "1.8"
            }
        }
    }
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach {
        it.binaries.framework {
            baseName = "fitness"
            listOf(":lib:shared", ":lib:features:authorization").forEach {  moduleDependency ->
                export(project(moduleDependency))
            }

            @Suppress("OPT_IN_USAGE")
            transitiveExport = true
            linkerOpts.add("-lsqlite3")
            embedBitcodeMode.set(BitcodeEmbeddingMode.BITCODE)
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                listOf(":lib:shared", ":lib:features:authorization").forEach {  moduleDependency ->
                    api(project(moduleDependency))
                }
            }
        }
    }
}

android {
    namespace = "ru.fitness.ios"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}


/*val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION").takeIf { it == "release" } ?: "DEBUG"
    val framework = kotlin.iosTarget.binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}*/

// tasks.getByName("build").dependsOn(packForXcode)
