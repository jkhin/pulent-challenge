package io.jk.pulent.challenge.core.network.api

import retrofit2.http.GET
import retrofit2.http.Query

interface ITunesAppleAPI {

    @GET("search")
    suspend fun getSearchResults(
        @Query("term") term : String,
        @Query("mediaType") mediaType: String? = "music",
        @Query("limit") limit: Int
    )

}