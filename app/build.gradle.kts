plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.jetbrains.kotlin.android)
    alias(libs.plugins.kotlin.serialization)
    alias(libs.plugins.kotlin.kapt)
}

android {
    namespace = "com.example.androidcourse"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.androidcourse"
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures {
        viewBinding = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.androidx.room.runtime)
    implementation(libs.androidx.room.ktx)
    implementation(libs.sqlite.jdbc)

    implementation(libs.dagger)
    kapt(libs.dagger.compiler)

    implementation(libs.androidx.lifecycle.viewmodel.ktx)

    implementation(libs.retrofit)
    implementation(libs.okhttp)
    implementation(libs.logging.interceptor)
    implementation(libs.retrofit2.kotlinx.serialization.converter)


    kapt(libs.androidx.room.compiler)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
