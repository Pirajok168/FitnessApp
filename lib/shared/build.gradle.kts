plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin(libs.plugins.kotlinSerialization.get().pluginId)
    // id(libs.plugins.sqldelightPlugin.get().pluginId)
}

kotlin {
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
            baseName = "shared"
            isStatic = true
        }
    }

    sourceSets {
        val commonMain by getting {
            dependencies {
                //put your multiplatform dependencies here
//                implementation(libs.kotlin.coroutines)
//                implementation(libs.kotlin.datetime)
//
//                implementation(libs.ktor.client.core)
//                implementation(libs.ktor.client.serialization)
//                implementation(libs.ktor.client.content.negotiation)
//                implementation(libs.ktor.serialization.kotlinx.json)
//
//                implementation(libs.kodein.di)
//
//                implementation(libs.app.cash.primitive.adapters)
            }
        }
        commonTest.dependencies {
            implementation(libs.kotlin.test)
        }
        androidMain.dependencies {
            implementation(libs.kviewmodel.compose)
            implementation(libs.compose.ui)
            implementation(libs.compose.foundation)
            implementation(libs.compose.ui.tooling.preview)
            implementation(libs.compose.material3)
            implementation(libs.androidx.activity.compose)
          //  implementation(libs.ktor.okhttp)
          //  implementation(libs.app.cash.android.driver)
        }


    }
}

android {
    namespace = "ru.fitness.mobile"
    compileSdk = 34
    defaultConfig {
        minSdk = 26
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = libs.versions.compose.compiler.get()
    }
}
