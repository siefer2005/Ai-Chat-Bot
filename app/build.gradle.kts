plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)


}

android {
    namespace = "com.helo.chatai"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.helo.chatai"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
    }
}


dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    implementation(libs.androidx.navigation.runtime.android)
    implementation(libs.play.services.mlkit.text.recognition.common)
    implementation(libs.digital.ink.recognition)
    implementation(libs.androidx.navigation.compose)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    implementation("com.google.ai.client.generativeai:generativeai:0.9.0")
    implementation(libs.coil.compose)
    implementation(libs.android.gif.drawable)
    implementation("io.coil-kt:coil-gif:2.5.0")
    implementation(libs.androidx.core.splashscreen)
    implementation("com.google.android.gms:play-services-location:21.1.0")
    implementation ("io.coil-kt:coil-compose:2.4.0")
    implementation ("io.coil-kt:coil-gif:2.4.0")
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("androidx.compose.material3:material3:1.1.2")
    implementation("com.google.android.material:material:1.11.0")


}