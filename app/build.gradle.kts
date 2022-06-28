
import com.growth.buildsrc.Libs

plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-kapt")
    id ("dagger.hilt.android.plugin")
    id("kotlin-parcelize")
}


android {
    compileSdk = 31


    defaultConfig {
        applicationId =  "com.growth.streetwarrior"
        minSdk = Libs.ConfigData.minSdkVersion
        targetSdk = Libs.ConfigData.targetSdkVersion
        versionCode = Libs.ConfigData.versionCode
        versionName = Libs.ConfigData.versionName


        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        getByName("release") {
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

    tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = Libs.AndroidX.Compose.version
        kotlinCompilerVersion = "1.5.21"
    }
    packagingOptions {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}


dependencies {
    implementation (Libs.Kotlin.stdlib)
    implementation (Libs.Kotlin.Coroutines.android)


    implementation (Libs.Accompanist.insets)
    implementation (Libs.AndroidX.Activity.activityCompose)
    implementation (Libs.AndroidX.appcompat)
    implementation (Libs.AndroidX.Compose.runtime)
    implementation (Libs.AndroidX.Compose.foundation)
    implementation (Libs.AndroidX.Compose.material)
    implementation (Libs.AndroidX.Compose.layout)
    implementation (Libs.AndroidX.Compose.animation)
    implementation (Libs.AndroidX.Compose.toolingPreview)
    implementation (Libs.AndroidX.Compose.ui)
    implementation (Libs.AndroidX.Compose.navigation)
    implementation (Libs.AndroidX.Compose.materialRipple)
    implementation (Libs.AndroidX.Lifecycle.viewModelCompose)
    implementation (Libs.AndroidX.Lifecycle.viewModelKtx)
    implementation (Libs.Hilt.android)

    implementation ("androidx.appcompat:appcompat:1.4.2")
    implementation ("com.google.android.material:material:1.4.0")
    implementation ("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation(Libs.JUnit.junit)


    debugImplementation (Libs.AndroidX.Compose.tooling)
    kapt (Libs.Hilt.compiler)

    debugImplementation (Libs.AndroidX.Compose.uiTestManifest)

    androidTestImplementation (Libs.JUnit.junit)
    androidTestImplementation (Libs.AndroidX.Test.core)
    androidTestImplementation (Libs.AndroidX.Test.runner)
    androidTestImplementation (Libs.AndroidX.Test.espressoCore)
    androidTestImplementation (Libs.AndroidX.Test.rules)
    androidTestImplementation (Libs.AndroidX.Test.Ext.junit)
    androidTestImplementation (Libs.Kotlin.Coroutines.test)
    androidTestImplementation (Libs.AndroidX.Compose.uiTest)
    androidTestImplementation (Libs.Hilt.android)
    androidTestImplementation (Libs.Hilt.testing)
    kaptAndroidTest (Libs.Hilt.compiler)
}
