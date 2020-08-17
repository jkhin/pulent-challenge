package io.jk.pulent.challenge.features.search.data.repository

import io.jk.pulent.challenge.core.utils.NetworkUtils
import io.jk.pulent.challenge.features.search.data.datasource.database.SongsLocalStorage
import io.jk.pulent.challenge.features.search.data.datasource.database.TermsLocalStorage
import io.jk.pulent.challenge.features.search.data.datasource.database.entity.SongEntity
import io.jk.pulent.challenge.features.search.data.datasource.database.entity.TermEntity
import io.jk.pulent.challenge.features.search.data.datasource.rest.SongCloudStore
import io.jk.pulent.challenge.features.search.data.datasource.rest.request.SearchRequest
import io.jk.pulent.challenge.features.search.data.datasource.rest.response.SongResponse
import io.jk.pulent.challenge.features.search.data.mapper.SongEntityMapper
import io.jk.pulent.challenge.features.search.data.mapper.SongMapper
import io.jk.pulent.challenge.features.search.domain.model.Song
import io.jk.pulent.challenge.features.search.domain.repository.SearchMusicRepository

class SearchMusicRepositoryImpl(
    private val cloudStore: SongCloudStore,
    private val termsLocalStorage: TermsLocalStorage,
    private val songsLocalStorage: SongsLocalStorage,
    private val songMapper: SongMapper,
    private val songEntityMapper: SongEntityMapper
): SearchMusicRepository {

    override suspend fun search(request: SearchRequest): List<Song> {
        return if (NetworkUtils.hasInternetConnection()) {
            saveTermIntoLocalStorage(request.term)

            val response = cloudStore.searchMusic(request)
            val entities = saveResultsAndGetSongsEntities(response.results)

            entities.map(songMapper::map)
        } else {
            saveTermIntoLocalStorage(request.term)

            val entities = songsLocalStorage.getSongs(request.term)
            val songs = entities.map(songMapper::map)
            songs
        }
    }

    private fun saveTermIntoLocalStorage(term: String) {
        val termHistoryEntity = createAndGetTermHistoryEntity(term)

        termsLocalStorage.saveTerm(termHistoryEntity)
    }

    private fun createAndGetTermHistoryEntity(term: String) = TermEntity(
        term = term,
        createdAt = System.currentTimeMillis()
    )

    private suspend fun saveResultsAndGetSongsEntities(results: List<SongResponse>): List<SongEntity> {
        val entities = results.map(songEntityMapper::map)
        songsLocalStorage.insertAllSongs(entities)
        return entities
    }

}