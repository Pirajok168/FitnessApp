plugins {
    //trick: for the same plugin versions in all sub-modules
    alias(libs.plugins.androidApplication).apply(false)
    alias(libs.plugins.androidLibrary).apply(false)
    alias(libs.plugins.kotlinAndroid).apply(false)
    alias(libs.plugins.kotlinMultiplatform).apply(false)
    alias(libs.plugins.sqldelightPlugin).apply(false)
    alias(libs.plugins.composePlugin).apply(false)
}

buildscript {
    dependencies {
        classpath(libs.kotlinx.serialization)
        classpath(libs.kotlin.serialization)
    }
}