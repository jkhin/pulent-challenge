package io.jk.pulent.challenge.features.search.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jk.pulent.challenge.core.extensions.io
import io.jk.pulent.challenge.core.extensions.ui
import io.jk.pulent.challenge.features.search.domain.interactor.SearchMusicUseCase
import io.jk.pulent.challenge.features.search.presentation.model.mapper.SongModelMapper
import io.jk.pulent.challenge.features.search.presentation.viewmodel.viewstate.SearchViewState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class SearchViewModel(
    private val searchMusicUseCase: SearchMusicUseCase,
    private val songModelMapper: SongModelMapper
) : ViewModel() {

    val state: LiveData<SearchViewState>
        get() = _state

    private var _state = MutableLiveData<SearchViewState>()

    fun searchMusic(term: String) {
        viewModelScope.launch(errorHandler) {
            io {
                val searchResults = searchMusicUseCase.searchMusic(term)
                val songs = searchResults.map(songModelMapper::map)

                ui {
                    _state.value = SearchViewState.SearchMusic(songs)
                }
            }
        }
    }

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        ui {
            exception.printStackTrace()
            _state.value = SearchViewState.NoResultsFound
        }
    }

}