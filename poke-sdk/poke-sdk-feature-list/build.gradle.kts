plugins {
    alias(libs.plugins.android.library)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = "com.kimbh.poke_sdk_feature_list"
    compileSdk = 36

    defaultConfig {
        minSdk = 24

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlin {
        compilerOptions {
            jvmTarget = org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_11
        }
    }
    buildFeatures {
        compose = true
    }
}

dependencies {
    implementation(project(":poke-sdk:poke-sdk-core"))
    implementation(project(":poke-sdk:poke-sdk-domain"))

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //Hilt
    implementation("com.google.dagger:hilt-android:2.57.1") // Hilt 런타임 라이브러리
    ksp("com.google.dagger:hilt-compiler:2.57.1")


    // paging Runtime (with Android dependencies)
    implementation(libs.androidx.paging.runtime)

    // alternatively - without Android dependencies for tests
    implementation(libs.androidx.paging.common)

    // paging - Compose
    implementation(libs.androidx.paging.compose)

    // viewModel - Compose
    implementation(libs.androidx.lifecycle.viewmodel.compose)
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")

    // compose
    implementation(platform(libs.androidx.compose.bom))
    // Material Design 3
    implementation("androidx.compose.material3:material3:1.3.2")
    // or only import the main APIs for the underlying toolkit systems,
    // such as input and measurement/layout
    implementation("androidx.compose.ui:ui:1.9.0")

    // Android Studio Preview support
    implementation("androidx.compose.ui:ui-tooling-preview:1.9.0")
    debugImplementation("androidx.compose.ui:ui-tooling:1.9.0")

    // UI Tests
    androidTestImplementation("androidx.compose.ui:ui-test-junit4:1.9.0")
    debugImplementation("androidx.compose.ui:ui-test-manifest:1.9.0")

    // Coil
    implementation("io.coil-kt.coil3:coil-compose:3.3.0")
    implementation("io.coil-kt.coil3:coil-network-okhttp:3.3.0")
    implementation("io.coil-kt.coil3:coil-svg:3.3.0")
}