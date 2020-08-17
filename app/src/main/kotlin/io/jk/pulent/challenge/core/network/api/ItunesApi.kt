package io.jk.pulent.challenge.core.network.api

import io.jk.pulent.challenge.features.search.data.datasource.rest.response.SearchResultResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryMap

interface ItunesApi {

    @GET("search")
    suspend fun getSearchResults(
        @Query("term") term : String,
        @Query("entity") entity: String,
        @Query("limit") limit: Int
    ): SearchResultResponse

}