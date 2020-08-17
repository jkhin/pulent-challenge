package io.jk.pulent.challenge

import applicationModules
import io.jk.pulent.challenge.core.utils.getComponent
import io.jk.pulent.challenge.features.search.data.datasource.rest.SongCloudStore
import io.jk.pulent.challenge.features.search.data.mapper.SongEntityMapper
import io.jk.pulent.challenge.features.search.data.mapper.SongMapper
import io.jk.pulent.challenge.features.search.domain.interactor.SearchMusicUseCase
import io.jk.pulent.challenge.features.search.domain.repository.SearchRepository
import io.jk.pulent.challenge.features.search.presentation.model.mapper.SongModelMapper
import org.amshove.kluent.shouldNotBeNull
import org.junit.Before
import org.junit.Test
import org.koin.core.context.startKoin
import org.koin.test.AutoCloseKoinTest


class DependenciesTest: AutoCloseKoinTest() {

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
        getComponent<SearchMusicUseCase>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for SearchRepository`() {
        getComponent<SearchRepository>().shouldNotBeNull()
    }

    @Test
    fun `solving dependencies for SongCLoudStore`() {
        getComponent<SongCloudStore>().shouldNotBeNull()
    }

}

