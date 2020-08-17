package io.jk.pulent.challenge.features.search.data.datasource.rest.request

data class SearchRequest(
    val term: String,
    val limit: Int? = 20,
    val entity: String? = "song"
)