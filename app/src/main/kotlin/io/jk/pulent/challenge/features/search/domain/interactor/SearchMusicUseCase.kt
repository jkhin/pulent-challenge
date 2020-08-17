package io.jk.pulent.challenge.features.search.domain.interactor

import io.jk.pulent.challenge.features.search.data.datasource.rest.request.SearchRequest
import io.jk.pulent.challenge.features.search.domain.model.Song
import io.jk.pulent.challenge.features.search.domain.repository.SearchMusicRepository

class SearchMusicUseCase(
    private val searchRepository: SearchMusicRepository
) {

    suspend fun searchMusic(term: String): List<Song> {
        val request = SearchRequest(term)
        return searchRepository.search(request)
    }

}