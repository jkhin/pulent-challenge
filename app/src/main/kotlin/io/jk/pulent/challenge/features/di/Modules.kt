package io.jk.pulent.challenge.features.di

import io.jk.pulent.challenge.core.utils.extensions.listByElementOf
import org.koin.core.module.Module

internal val featuresModule by lazy {
    listByElementOf<Module>(
        homeModule,
        detailModule,
        searchModule
    )
}