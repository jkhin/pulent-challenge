package io.jk.pulent.challenge.features.di

import io.jk.pulent.challenge.core.network.core.NAMED_ITUNES_APPLE_API
import io.jk.pulent.challenge.features.search.data.datasource.database.SongsLocalStorage
import io.jk.pulent.challenge.features.search.data.datasource.rest.SongCloudStore
import io.jk.pulent.challenge.features.search.data.mapper.SongEntityMapper
import io.jk.pulent.challenge.features.search.data.mapper.SongMapper
import io.jk.pulent.challenge.features.search.data.repository.SongsRepositoryImpl
import io.jk.pulent.challenge.features.search.domain.interactor.SearchSongsUseCase
import io.jk.pulent.challenge.features.search.domain.repository.SongsRepository
import io.jk.pulent.challenge.features.search.presentation.model.mapper.SongModelMapper
import io.jk.pulent.challenge.features.search.presentation.viewmodel.SongsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val searchModule by lazy {
    module {
        viewModel { SongsViewModel(get(), get()) }

        single { SongModelMapper() }
        single { SongMapper() }
        single { SongEntityMapper() }

        single { SearchSongsUseCase(get()) }

        single<SongsRepository> { SongsRepositoryImpl(get(), get(), get(), get(), get()) }

        single { SongCloudStore(get(named(NAMED_ITUNES_APPLE_API))) }

        single { SongsLocalStorage() }
    }
}