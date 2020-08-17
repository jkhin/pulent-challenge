package io.jk.pulent.challenge.features.search.presentation.viewmodel.viewstate

import io.jk.pulent.challenge.features.search.presentation.model.SongModel

sealed class SearchViewState {
    class SuccessSearch(val results: List<SongModel>): SearchViewState()
    object NoResultsFound: SearchViewState()
}