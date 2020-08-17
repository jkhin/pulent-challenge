package io.jk.pulent.challenge.features.search.domain.repository

import io.jk.pulent.challenge.features.search.data.datasource.rest.request.SearchRequest
import io.jk.pulent.challenge.features.search.domain.model.Song

interface SearchRepository {
    suspend fun search(request: SearchRequest): List<Song>
}