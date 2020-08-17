package io.jk.pulent.challenge.features.home.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jk.pulent.challenge.core.extensions.io
import io.jk.pulent.challenge.core.extensions.ui
import io.jk.pulent.challenge.features.home.domain.interactor.GetTermsUseCase
import io.jk.pulent.challenge.features.home.presentation.model.mapper.TermsModelMapper
import io.jk.pulent.challenge.features.home.presentation.viewmodel.viewstate.TermViewState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class TermsViewModel(
    private val getTermsUseCase: GetTermsUseCase,
    private val termsModelMapper: TermsModelMapper
) : ViewModel() {

    val state: LiveData<TermViewState>
        get() = _state

    private var _state: MutableLiveData<TermViewState> = MutableLiveData()


    fun getAllTermsStored() {
        viewModelScope.launch(errorHandler) {
            io {
                val searchResults = getTermsUseCase.getTermsHistory()
                val terms = searchResults.map(termsModelMapper::map)

                ui {
                    _state.value = TermViewState.TermStored(terms)
                }
            }
        }
    }


    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        ui { exception.printStackTrace() }
    }
}