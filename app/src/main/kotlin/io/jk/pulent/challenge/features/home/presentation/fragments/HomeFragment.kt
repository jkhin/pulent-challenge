package io.jk.pulent.challenge.features.home.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.lapism.search.internal.SearchLayout
import io.jk.pulent.challenge.R
import io.jk.pulent.challenge.features.home.presentation.model.TermHistoryModel
import io.jk.pulent.challenge.features.home.presentation.viewmodel.TermsViewModel
import io.jk.pulent.challenge.features.home.presentation.viewmodel.viewstate.TermViewState
import io.jk.pulent.challenge.features.search.presentation.adapters.SearchResultsAdapter
import io.jk.pulent.challenge.features.search.presentation.adapters.TermsHistoryAdapter
import io.jk.pulent.challenge.features.search.presentation.model.SongModel
import io.jk.pulent.challenge.features.search.presentation.viewmodel.SongsViewModel
import io.jk.pulent.challenge.features.search.presentation.viewmodel.viewstate.SongsViewState
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment(), TermsHistoryAdapter.Listener {

    private val searchViewModel by viewModel<SongsViewModel>()

    private val termsViewModel by viewModel<TermsViewModel>()

    private val termsAdapter: TermsHistoryAdapter by lazy {
        TermsHistoryAdapter(this@HomeFragment)
    }

    private val searchResultsAdapter: SearchResultsAdapter by lazy {
        SearchResultsAdapter()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeObservers()
        initializeViewSettings()
        initializeViewEvents()
    }

    private fun updateTermsInAdapter(terms: List<TermHistoryModel>) {
        termsAdapter.clearAndAddAll(terms)
    }

    private fun updateSearchResultsAdapter(songs: List<SongModel>) {
        searchResultsAdapter.clearAndAddAll(songs)
    }

    private fun initializeObservers() {
        termsViewModel.state.observe(viewLifecycleOwner, Observer<TermViewState> {
            when (it) {
                is TermViewState.TermStored -> updateTermsInAdapter(it.terms)
            }
        })
        searchViewModel.state.observe(viewLifecycleOwner, Observer<SongsViewState> {
            when (it) {
                is SongsViewState.SuccessSearch -> updateSearchResultsAdapter(it.results)
                is SongsViewState.OnLoading -> {
                    loadingAnimation?.visibility = if (it.isLoading) View.VISIBLE else View.GONE
                    rvHomeSearchResults?.visibility = if (it.isLoading) View.GONE else View.VISIBLE
                }
            }
        })
    }

    private fun initializeViewSettings() {
        msHomeSearchInput?.apply {
            setAdapterLayoutManager(
                LinearLayoutManager(
                    context,
                    LinearLayoutManager.VERTICAL,
                    false
                )
            )
            setAdapter(termsAdapter)
            setTextHint(getString(R.string.text_type_song_name))
        }

        rvHomeSearchResults?.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
            adapter = searchResultsAdapter
            layoutAnimation = AnimationUtils.loadLayoutAnimation(requireContext(), R.anim.layout_animation_fall_down)
        }
    }

    private fun initializeViewEvents() {
        msHomeSearchInput?.apply {
            setOnNavigationClickListener(object : SearchLayout.OnNavigationClickListener {
                override fun onNavigationClick() {
                    msHomeSearchInput.requestFocus()
                }
            })

            setOnQueryTextListener(object : SearchLayout.OnQueryTextListener {
                override fun onQueryTextChange(newText: CharSequence): Boolean {
                    with(termsAdapter) {
                        if (newText.isNotBlank()) filter(newText.toString()) else clearFilter()
                    }
                    return true
                }

                override fun onQueryTextSubmit(query: CharSequence): Boolean {
                    msHomeSearchInput?.clearFocus()
                    searchViewModel.searchSongs(query.toString())
                    return true
                }
            })

            setOnFocusChangeListener(object : SearchLayout.OnFocusChangeListener {
                override fun onFocusChange(hasFocus: Boolean) {
                    navigationIconSupport = if (hasFocus) {
                        termsViewModel.getAllTermsStored()
                        SearchLayout.NavigationIconSupport.ARROW
                    } else {
                        termsAdapter.clearAndAddAll(emptyList())
                        SearchLayout.NavigationIconSupport.NONE
                    }
                }
            })
        }

    }

    override fun doOnTermSelected(term: String) {
        msHomeSearchInput?.clearFocus()
        searchViewModel.searchSongs(term)
    }

}