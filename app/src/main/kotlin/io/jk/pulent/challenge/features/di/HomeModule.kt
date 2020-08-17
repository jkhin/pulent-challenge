package io.jk.pulent.challenge.features.di

import io.jk.pulent.challenge.features.home.data.mapper.TermsMapper
import io.jk.pulent.challenge.features.home.data.repository.TermsRepositoryImpl
import io.jk.pulent.challenge.features.home.domain.interactor.GetTermsUseCase
import io.jk.pulent.challenge.features.home.domain.repository.TermsRepository
import io.jk.pulent.challenge.features.home.presentation.model.mapper.TermsModelMapper
import io.jk.pulent.challenge.features.home.presentation.viewmodel.TermsViewModel
import io.jk.pulent.challenge.features.search.data.datasource.database.TermsLocalStorage
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

internal val homeModule by lazy {
    module {
        viewModel { TermsViewModel(get(), get()) }

        single { TermsMapper() }
        single { TermsModelMapper() }

        single { GetTermsUseCase(get()) }

        single<TermsRepository> { TermsRepositoryImpl(get(), get()) }

        single { TermsLocalStorage() }
    }
}