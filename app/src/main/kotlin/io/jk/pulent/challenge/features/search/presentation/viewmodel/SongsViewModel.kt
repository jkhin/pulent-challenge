package io.jk.pulent.challenge.features.search.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.jk.pulent.challenge.core.extensions.io
import io.jk.pulent.challenge.core.extensions.ui
import io.jk.pulent.challenge.features.search.domain.interactor.SearchSongsUseCase
import io.jk.pulent.challenge.features.search.presentation.model.mapper.SongModelMapper
import io.jk.pulent.challenge.features.search.presentation.viewmodel.viewstate.SongsViewState
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.launch

class SongsViewModel(
    private val searchMusicUseCase: SearchSongsUseCase,
    private val songModelMapper: SongModelMapper
) : ViewModel() {

    val state: LiveData<SongsViewState>
        get() = _state

    private var _state = MutableLiveData<SongsViewState>()

    fun searchSongs(term: String) {
        viewModelScope.launch(errorHandler) {
            ui {
                _state.value = SongsViewState.OnLoading(true)
            }
            io {
                val searchResults = searchMusicUseCase.searchSongs(term)
                val songs = searchResults.map(songModelMapper::map)

                ui {
                    _state.value = SongsViewState.OnLoading(false)
                    _state.value = SongsViewState.SuccessSearch(songs)
                }
            }
        }
    }

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        ui {
            exception.printStackTrace()
            _state.value = SongsViewState.OnLoading(false)
            _state.value = SongsViewState.NoResultsFound
        }
    }

}