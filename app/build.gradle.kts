
plugins {
    id("com.android.application")
}

android {
    namespace = "df.root"
    compileSdk = 37

    defaultConfig {
        applicationId = "df.root"
        minSdk = 32
        targetSdk = 37
        versionCode = 34
        versionName = "1.17"

        ndk {
            abiFilters += listOf("arm64-v8a")
        }
    }

    buildTypes {
        debug {
            // ใช้ Android Debug Keystore อัตโนมัติ
            // ไม่ต้องใช้ app/keystore.jks
        }

        release {
            isMinifyEnabled = true
            isShrinkResources = true

            proguardFiles(
                getDefaultProguardFile(
                    "proguard-android-optimize.txt"
                ),
                "proguard-rules.pro"
            )
        }
    }

    androidComponents {
        onVariants { variant ->
            variant.outputs.forEach { output ->
                output.outputFileName.set("sonteen.apk")
            }
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }

    lint {
        checkReleaseBuilds = false
    }

    buildFeatures {
        viewBinding = false
        buildConfig = true
    }

    packaging {
        jniLibs {
            useLegacyPackaging = true
        }
    }
}

dependencies {
    // UI-only dependencies
}
