package io.jk.pulent.challenge

import applicationModules
import io.jk.pulent.challenge.core.utils.getComponent
import io.jk.pulent.challenge.features.home.data.mapper.TermsMapper
import io.jk.pulent.challenge.features.home.data.repository.TermsRepositoryImpl
import io.jk.pulent.challenge.features.home.domain.interactor.GetTermsUseCase
import io.jk.pulent.challenge.features.home.domain.repository.TermsRepository
import io.jk.pulent.challenge.features.home.presentation.model.mapper.TermsModelMapper
import io.jk.pulent.challenge.features.home.presentation.viewmodel.TermsViewModel
import io.jk.pulent.challenge.features.search.data.datasource.database.TermsLocalStorage
import io.jk.pulent.challenge.features.search.data.datasource.rest.SongCloudStore
import org.amshove.kluent.shouldNotBeNull
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest


class HomeModuleDependenciesTest: AutoCloseKoinTest() {

    @Before
    fun setup() {
        startKoin {
            printLogger()
            modules(applicationModules)
        }
    }

    @Test
    fun `solving dependencies for TermsViewModel`() {
        getComponent<TermsViewModel>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for TermsModelMapper`() {
        getComponent<TermsModelMapper>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for GetTermsUseCase`() {
        getComponent<GetTermsUseCase>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for TermsRepository`() {
        getComponent<TermsRepository>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for TermsMapper`() {
        getComponent<TermsMapper>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for TermsLocalStorage`() {
        getComponent<TermsLocalStorage>().shouldNotBeNull()
    }

}