package io.jk.pulent.challenge.features.search.presentation.viewmodel.viewstate

import io.jk.pulent.challenge.features.search.presentation.model.SongModel

sealed class SearchViewState {
    class SearchMusic(val results: List<SongModel>): SearchViewState()
    object NoResultsFound: SearchViewState()
}