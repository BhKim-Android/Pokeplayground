plugins {
    id("java-library")
    alias(libs.plugins.jetbrains.kotlin.jvm)
}
java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}
kotlin {
    compilerOptions {
        jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
    }
}

dependencies {
    implementation(project(":poke-sdk:poke-sdk-core"))

    implementation("javax.inject:javax.inject:1")

    implementation(libs.kotlinx.coroutines.android)

    // alternatively - without Android dependencies for tests
    implementation(libs.androidx.paging.common)
}
