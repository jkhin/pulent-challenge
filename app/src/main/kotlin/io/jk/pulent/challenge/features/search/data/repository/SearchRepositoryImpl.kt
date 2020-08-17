package io.jk.pulent.challenge.features.search.data.repository

import android.util.Log
import io.jk.pulent.challenge.features.search.data.datasource.rest.SongCloudStore
import io.jk.pulent.challenge.features.search.data.datasource.rest.request.SearchRequest
import io.jk.pulent.challenge.features.search.data.mapper.SongEntityMapper
import io.jk.pulent.challenge.features.search.data.mapper.SongMapper
import io.jk.pulent.challenge.features.search.domain.model.Song
import io.jk.pulent.challenge.features.search.domain.repository.SearchRepository

class SearchRepositoryImpl(
    private val cloudStore: SongCloudStore,
    private val songMapper: SongMapper,
    private val songEntityMapper: SongEntityMapper
): SearchRepository {

    override suspend fun search(request: SearchRequest): List<Song> {
        Log.d("response", request.toString())

        // TODO("Check if device has internet")
        // TODO("Search if device has stored data")
        // TODO("If device has stored data then return it")
        // TODO("else return empty data OR return no internet connection available error")
        val response = cloudStore.searchMusic(request)
        Log.d("response", response.toString())
        val entities = response.results.map(songEntityMapper::map)
        val songs = entities.map(songMapper::map)

        return songs
    }

}