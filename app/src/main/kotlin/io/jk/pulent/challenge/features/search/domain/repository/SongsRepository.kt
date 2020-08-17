package io.jk.pulent.challenge.features.search.domain.repository

import io.jk.pulent.challenge.features.search.data.datasource.rest.request.SearchRequest
import io.jk.pulent.challenge.features.search.domain.model.Song

interface SongsRepository {
    suspend fun searchSongs(request: SearchRequest): List<Song>
}