package io.jk.pulent.challenge.core.network.core

import io.jk.pulent.challenge.core.network.api.ItunesApi
import io.jk.pulent.challenge.core.utils.createHttpClient
import io.jk.pulent.challenge.core.utils.createRetrofit
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit


const val NAMED_ITUNES_APPLE_CLIENT = "ITUNES_APPLE_CLIENT"
const val NAMED_ITUNES_APPLE = "ITUNES_APPLE"
const val NAMED_ITUNES_APPLE_API = "NAMED_ITUNES_APPLE_API"

internal val networkModule by lazy {

    module {
        single(named(NAMED_ITUNES_APPLE_CLIENT)) { createHttpClient() }

        single(named(NAMED_ITUNES_APPLE)) {
            createRetrofit(
                get(named(NAMED_ITUNES_APPLE_CLIENT))
            )
        }

        single(named(NAMED_ITUNES_APPLE_API)) { provideItunesAppleApi(get(named(NAMED_ITUNES_APPLE))) }
    }

}

fun provideItunesAppleApi(retrofit: Retrofit): ItunesApi {
    return retrofit.create(ItunesApi::class.java)
}