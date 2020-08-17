package io.jk.pulent.challenge.core.utils

import io.jk.pulent.challenge.BuildConfig
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.util.concurrent.TimeUnit


fun createHttpClient(): OkHttpClient {
    return OkHttpClient().newBuilder()
        .connectTimeout(180, TimeUnit.SECONDS)
        .readTimeout(180, TimeUnit.SECONDS)
        .writeTimeout(180, TimeUnit.SECONDS)
        .build()
}

fun createRetrofit(httpClient: OkHttpClient) = Retrofit.Builder()
    .baseUrl(BuildConfig.ITUNES_APPLE_API)
    .client(httpClient)
    .addConverterFactory(ScalarsConverterFactory.create())
    .addConverterFactory(MoshiConverterFactory.create())
    .build()
