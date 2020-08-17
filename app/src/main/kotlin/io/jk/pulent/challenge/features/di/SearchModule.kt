package io.jk.pulent.challenge.features.di

import io.jk.pulent.challenge.core.network.core.NAMED_ITUNES_APPLE_API
import io.jk.pulent.challenge.features.search.data.datasource.database.SongsLocalStorage
import io.jk.pulent.challenge.features.search.data.datasource.database.TermsLocalStorage
import io.jk.pulent.challenge.features.search.data.datasource.rest.SongCloudStore
import io.jk.pulent.challenge.features.search.data.mapper.SongEntityMapper
import io.jk.pulent.challenge.features.search.data.mapper.SongMapper
import io.jk.pulent.challenge.features.search.data.repository.SearchMusicRepositoryImpl
import io.jk.pulent.challenge.features.search.domain.interactor.SearchMusicUseCase
import io.jk.pulent.challenge.features.search.domain.repository.SearchMusicRepository
import io.jk.pulent.challenge.features.search.presentation.model.mapper.SongModelMapper
import io.jk.pulent.challenge.features.search.presentation.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

internal val searchModule by lazy {
    module {
        viewModel { SearchViewModel(get(), get()) }

        single { SongModelMapper() }
        single { SongMapper() }
        single { SongEntityMapper() }

        single { SearchMusicUseCase(get()) }

        single<SearchMusicRepository> { SearchMusicRepositoryImpl(get(), get(), get(), get(), get()) }

        single { SongCloudStore(get(named(NAMED_ITUNES_APPLE_API))) }

        single { SongsLocalStorage() }
    }
}