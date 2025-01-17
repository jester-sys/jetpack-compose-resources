plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

}

android {
    namespace = "com.example.jetpack"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.jetpack"
        minSdk = 24
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
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
    implementation(libs.androidx.ui.test.android)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
    // Accompanist Pager
    implementation ("com.google.accompanist:accompanist-pager:0.24.13-rc")
    implementation ("com.google.accompanist:accompanist-pager-indicators:0.24.13-rc")
    // Navigation component for Jetpack Compose
    implementation ("androidx.navigation:navigation-compose:2.7.0")

    // Voyager Core
    implementation("cafe.adriel.voyager:voyager-navigator:1.0.0-rc06")

    // Optional modules (use only what you need):
    // Animations for screen transitions
    implementation("cafe.adriel.voyager:voyager-transitions:1.0.0-rc06")

    // Bottom sheet navigation
    implementation("cafe.adriel.voyager:voyager-bottom-sheet-navigator:1.0.0-rc06")

    // Tab navigation
    implementation("cafe.adriel.voyager:voyager-tab-navigator:1.0.0-rc06")

    // AndroidX ViewModel integration
    implementation("cafe.adriel.voyager:voyager-androidx:1.0.0-rc06")

    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.1")
    implementation ("com.google.accompanist:accompanist-flowlayout:0.26.4-beta")


}
