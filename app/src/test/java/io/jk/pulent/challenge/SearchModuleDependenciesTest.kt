package io.jk.pulent.challenge

import applicationModules
import io.jk.pulent.challenge.core.utils.getComponent
import io.jk.pulent.challenge.features.search.data.datasource.database.SongsLocalStorage
import io.jk.pulent.challenge.features.search.data.datasource.rest.SongCloudStore
import io.jk.pulent.challenge.features.search.data.mapper.SongEntityMapper
import io.jk.pulent.challenge.features.search.data.mapper.SongMapper
import io.jk.pulent.challenge.features.search.domain.interactor.SearchSongsUseCase
import io.jk.pulent.challenge.features.search.domain.repository.SongsRepository
import io.jk.pulent.challenge.features.search.presentation.model.mapper.SongModelMapper
import org.amshove.kluent.shouldNotBeNull
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest

class SearchModuleDependenciesTest: AutoCloseKoinTest() {

    @Before
    fun setup() {
        startKoin {
            printLogger()
            modules(applicationModules)
        }
    }

    @Test
    fun `solving dependencies for SearchViewModel`() {
        getComponent<SongCloudStore>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for SongModelMapper`() {
        getComponent<SongModelMapper>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for SongEntityMapper`() {
        getComponent<SongEntityMapper>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for SongMapper`() {
        getComponent<SongMapper>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for SearchMusicUseCase`() {
        getComponent<SearchSongsUseCase>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for SearchRepository`() {
        getComponent<SongsRepository>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for SongCloudStore`() {
        getComponent<SongCloudStore>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for SongsLocalStorage`() {
        getComponent<SongsLocalStorage>().shouldNotBeNull()
    }

}

