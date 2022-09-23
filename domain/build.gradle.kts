import com.growth.buildsrc.Libs

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
    implementation (platform(Libs.Firebase.firebaseBoom))
    implementation (Libs.Firebase.firebaseAuth)
    implementation (Libs.Firebase.serviceAuth)

    implementation (Libs.Kotlin.Coroutines.android)
    implementation (Libs.Firebase.firestore)
    testImplementation(Libs.JUnit.junit)

    implementation (Libs.Hilt.android)
}