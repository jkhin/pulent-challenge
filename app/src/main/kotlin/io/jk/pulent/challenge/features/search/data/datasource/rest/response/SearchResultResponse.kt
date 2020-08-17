package io.jk.pulent.challenge.features.search.data.datasource.rest.response

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class SearchResultResponse(
    val resultCount: Int,
    val results: List<SongResponse>
)

