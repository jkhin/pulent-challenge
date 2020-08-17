package io.jk.pulent.challenge.features.home.presentation.viewmodel.viewstate

import io.jk.pulent.challenge.features.home.presentation.model.TermHistoryModel

sealed class TermViewState {
    class TermStored(val terms: List<TermHistoryModel>): TermViewState()
}