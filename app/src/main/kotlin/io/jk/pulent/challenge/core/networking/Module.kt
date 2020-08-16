package io.jk.pulent.challenge.core.networking

import org.koin.core.qualifier.named
import org.koin.dsl.module


const val NAMED_ITUNES_APPLE_CLIENT = "ITUNES_APPLE_CLIENT"
const val NAMED_ITUNES_APPLE = "ITUNES_APPLE"

internal val networkModule by lazy {
    module {
        single(named(NAMED_ITUNES_APPLE_CLIENT)) {  }
    }
}