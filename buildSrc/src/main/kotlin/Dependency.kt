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

    object Kotlin {
        const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.Kotlin.kotlinVersion}"
    }

    object Koin {
        const val koin = "org.koin:koin-android:${Versions.Koin.koinVersion}"
        const val koinViewModel = "org.koin:koin-androidx-viewmodel:${Versions.Koin.koinVersion}"
    }

    object Tests {
        const val jUnit = "junit:junit:${Versions.Tests.jUnitVersion}"
        const val androidxTestExt = "androidx.test.ext:junit:${Versions.Tests.androidxTestExtVersion}"
        const val espressoCore =
            "androidx.test.espresso:espresso-core:${Versions.Tests.espressoCoreVersion}"
    }

    object Fresco {
        const val fresco = "com.facebook.fresco:fresco:${Versions.Fresco.frescoVersion}"
    }

    object Rx {
        const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.Rx.rxAndroidVersion}"
        const val rxKotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.Rx.rxKotlinVersion}"
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
