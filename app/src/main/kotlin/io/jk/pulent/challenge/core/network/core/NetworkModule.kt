package io.jk.pulent.challenge.core.network.core

import io.jk.pulent.challenge.core.network.api.ITunesAppleAPI
import io.jk.pulent.challenge.core.utils.createHttpClient
import io.jk.pulent.challenge.core.utils.createRetrofit
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit


const val NAMED_ITUNES_APPLE_CLIENT = "ITUNES_APPLE_CLIENT"
const val NAMED_ITUNES_APPLE = "ITUNES_APPLE"

internal val networkModule by lazy {

    module {
        single(named(NAMED_ITUNES_APPLE_CLIENT)) { createHttpClient() }

        single(named(NAMED_ITUNES_APPLE)) {
            createRetrofit(
                get(named(NAMED_ITUNES_APPLE_CLIENT))
            )
        }

        single {
            provideItunesAppleApi(
                get(named(NAMED_ITUNES_APPLE))
            )
        }
    }

}

fun provideItunesAppleApi(retrofit: Retrofit): ITunesAppleAPI {
    return retrofit.create(ITunesAppleAPI::class.java)
}