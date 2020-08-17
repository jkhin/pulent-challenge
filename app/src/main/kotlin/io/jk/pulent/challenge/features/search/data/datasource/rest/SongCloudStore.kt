package io.jk.pulent.challenge.features.search.data.datasource.rest

import io.jk.pulent.challenge.core.network.api.ItunesApi
import io.jk.pulent.challenge.features.search.data.datasource.rest.request.SearchRequest
import io.jk.pulent.challenge.features.search.data.datasource.rest.response.SearchResultResponse

class SongCloudStore(
    private val itunesApi: ItunesApi
) {

    suspend fun searchMusic(request: SearchRequest): SearchResultResponse = with(request) {
        return@with itunesApi.getSearchResults(term = term, entity = entity!!, limit = limit!!)
    }

}