import com.growth.buildsrc.Libs

plugins {
    id ("com.android.library")
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

    implementation (Libs.AndroidX.Compose.runtime)
    implementation (Libs.AndroidX.Compose.foundation)
    implementation (Libs.AndroidX.Compose.material)
    implementation (Libs.AndroidX.Compose.layout)
    implementation (Libs.AndroidX.Compose.animation)
    implementation (Libs.AndroidX.Compose.toolingPreview)
    implementation (Libs.AndroidX.Compose.ui)
    implementation (Libs.AndroidX.Compose.navigation)
    implementation (Libs.AndroidX.Compose.materialWindowSize)
    implementation (Libs.AndroidX.Lifecycle.viewModelCompose)
    implementation (Libs.AndroidX.Lifecycle.viewModelKtx)
    implementation(project(mapOf("path" to ":domain")))

    testImplementation(Libs.JUnit.junit)
}