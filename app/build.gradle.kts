plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.example.newappwiser"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.newappwiser"
        minSdk = 26
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
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

    // Tambahkan dependency Coil untuk loading gambar
    implementation("io.coil-kt:coil-compose:2.1.0") // Pastikan versi terbaru dari Coil

    // Dependency navigation-compose versi stabil
    implementation("androidx.navigation:navigation-compose:2.4.0")

    // Dependency untuk pengujian unit
    testImplementation(libs.junit)

    // Dependency untuk pengujian instrumented
    androidTestImplementation("androidx.test.ext:junit:1.1.5") // JUnit extensions untuk AndroidX
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1") // Espresso untuk testing UI
    androidTestImplementation("androidx.test:core-ktx:1.5.0") // Optional untuk KTX API

    // Dependency pengujian untuk Compose
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)
}
