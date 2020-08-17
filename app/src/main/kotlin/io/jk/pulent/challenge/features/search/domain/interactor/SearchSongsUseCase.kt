package io.jk.pulent.challenge.features.search.domain.interactor

import io.jk.pulent.challenge.features.search.data.datasource.rest.request.SearchRequest
import io.jk.pulent.challenge.features.search.domain.model.Song
import io.jk.pulent.challenge.features.search.domain.repository.SongsRepository

class SearchSongsUseCase(
    private val songsRepository: SongsRepository
) {

    suspend fun searchSongs(term: String): List<Song> {
        val request = SearchRequest(term)
        return songsRepository.searchSongs(request)
    }

}