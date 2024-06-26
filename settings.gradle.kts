enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")
pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "FitnessApp"
include(":androidApp")
include(":lib:shared")
include(":lib:ios-framework")
include(":lib:designsystem")

include(":lib:features:authorization", ":lib:features:authorization:data", ":lib:features:authorization:domain")