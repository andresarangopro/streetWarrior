import com.bike.buildsrc.Libs
import com.bike.buildsrc.implementationOwn

plugins {
    id("com.android.library")
    id ("kotlin-android")
    id ("kotlin-kapt")
}

android {
    compileSdk = 32

    defaultConfig {
        minSdk = Libs.ConfigData.minSdkVersion
        targetSdk = Libs.ConfigData.targetSdkVersion

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
}

dependencies {
    implementation("androidx.core:core-ktx:1.7.0")
    implementation(project(mapOf("path" to ":domain")))
    implementation (platform(Libs.Firebase.firebaseBoom))
    implementation (Libs.Firebase.firebaseAuth)
    implementation (Libs.Firebase.serviceAuth)
    implementation (Libs.Firebase.firestore)
    implementation (Libs.Kotlin.Coroutines.android)
    implementation (Libs.Kotlin.Coroutines.core)
    implementation (Libs.Kotlin.Coroutines.playServices)
    implementation (Libs.Hilt.android)
    testImplementation(Libs.JUnit.junit)
    implementationOwn(Libs.retrofitLibraries)
}