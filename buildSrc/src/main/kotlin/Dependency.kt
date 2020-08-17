object Dependency {

    object BuildPlugins {
        const val androidGradle =
            "com.android.tools.build:gradle:${Versions.androidGradlePluginVersion}"
    }

    object Android {
        const val constraintLayout =
            "androidx.constraintlayout:constraintlayout:${Versions.AndroidLib.constraintLayoutVersion}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.AndroidLib.appCompatVersion}"
        const val androidKTX = "androidx.core:core-ktx:${Versions.AndroidLib.androidxKTXVersion}"
        const val androidLifeCycleViewModel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.AndroidLib.androidLifeCycleViewModelVersion}"

        const val androidNavigationFragment =
            "androidx.navigation:navigation-fragment-ktx:${Versions.AndroidLib.androidNavigationVersion}"
        const val androidNavigationUIKt =
            "androidx.navigation:navigation-ui-ktx:${Versions.AndroidLib.androidNavigationVersion}"
        const val androidMaterial =
            "com.google.android.material:material:${Versions.AndroidLib.androidMaterialVersion}"
    }

    object MaterialSearch {
        const val materialSearch = "com.lapism:search:${Versions.MaterialSearch.materialSearchVersion}"
    }

    object Kotlin {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin.kotlinVersion}"
        const val kotlinCoroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.Kotlin.kotlinCoroutinesVersion}"
    }

    object Koin {
        const val koin = "org.koin:koin-android:${Versions.Koin.koinVersion}"
        const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.Koin.koinVersion}"
        const val koinTest = "org.koin:koin-test:${Versions.Koin.koinTestVersion}"
    }

    object Tests {
        const val jUnit = "junit:junit:${Versions.Tests.jUnitVersion}"
        const val androidxTestCore = "androidx.test:core:${Versions.Tests.androidxTestCore}"
        const val androidxTestExt = "androidx.test.ext:junit:${Versions.Tests.androidxTestExtVersion}"
        const val espressoCore =
            "androidx.test.espresso:espresso-core:${Versions.Tests.espressoCoreVersion}"
        const val kluent = "org.amshove.kluent:kluent-android:${Versions.Tests.kluentVersion}"
    }

    object Room {
       const val roomRuntime = "androidx.room:room-runtime:${Versions.Room.roomVersion}"
       const val roomCompiler = "androidx.room:room-compiler:${Versions.Room.roomVersion}"
       const val roomKtx = "androidx.room:room-ktx:${Versions.Room.roomVersion}"
       const val roomTesting = "androidx.room:room-testing:${Versions.Room.roomVersion}"
    }

    object Fresco {
        const val fresco = "com.facebook.fresco:fresco:${Versions.Fresco.frescoVersion}"
    }

    object Lottie {
        const val lottie = "com.airbnb.android:lottie:${Versions.Lottie.lottieVersion}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.Retrofit.retrofitVersion}"
        const val retrofitConverterMoshi = "com.squareup.retrofit2:converter-moshi:${Versions.Retrofit.retrofitVersion}"
        const val retrofitConverterScalars = "com.squareup.retrofit2:converter-scalars:${Versions.Retrofit.retrofitVersion}"
    }
    object OkHttp {
        const val okHttp3 = "com.squareup.okhttp3:okhttp:${Versions.OkHttp.okHttpVersion}"
        const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.OkHttp.okHttpInterceptorVersion}"
    }

    object Moshi {
        const val moshi = "com.squareup.moshi:moshi:${Versions.Moshi.moshiVersion}"
        const val moshiCodeGen = "com.squareup.moshi:moshi-kotlin-codegen:${Versions.Moshi.moshiVersion}"
        const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:${Versions.Moshi.moshiVersion}"
    }

}
