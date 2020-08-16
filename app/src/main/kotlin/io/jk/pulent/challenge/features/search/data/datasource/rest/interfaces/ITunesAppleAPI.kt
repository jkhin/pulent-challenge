package io.jk.pulent.challenge.features.search.data.datasource.rest.interfaces

import io.jk.pulent.challenge.features.search.data.datasource.rest.response.SearchResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesAppleAPI {

    @GET("search")
    suspend fun getSearchResults(
        @Query("term") term : String,
        @Query("mediaType") mediaType: String? = "music",
        @Query("limit") limit: Int
    ): SearchResponse

}