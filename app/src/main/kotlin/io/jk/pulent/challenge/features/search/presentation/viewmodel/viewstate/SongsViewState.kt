package io.jk.pulent.challenge.features.search.presentation.viewmodel.viewstate

import io.jk.pulent.challenge.features.search.presentation.model.SongModel

sealed class SongsViewState {
    class SuccessSearch(val results: List<SongModel>): SongsViewState()
    class OnLoading(val isLoading: Boolean) : SongsViewState()
    object NoResultsFound: SongsViewState()
}