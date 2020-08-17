package io.jk.pulent.challenge.features.home.presentation.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.lapism.search.internal.SearchLayout
import io.jk.pulent.challenge.R
import io.jk.pulent.challenge.features.search.presentation.adapters.TermsHistoryAdapter
import io.jk.pulent.challenge.features.home.presentation.model.TermHistoryModel
import io.jk.pulent.challenge.features.home.presentation.viewmodel.TermsViewModel
import io.jk.pulent.challenge.features.home.presentation.viewmodel.viewstate.TermViewState
import io.jk.pulent.challenge.features.search.presentation.viewmodel.SearchViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity(), TermsHistoryAdapter.Listener {

    private val searchViewModel by viewModel<SearchViewModel>()

    private val termsViewModel by viewModel<TermsViewModel>()

    private val termsAdapter: TermsHistoryAdapter by lazy { TermsHistoryAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeObservers()
        initializeViewSettings()
        initializeViewEvents()
    }

    private fun updateTermsInAdapter(terms: List<TermHistoryModel>) {
        termsAdapter.clearAndAddAll(terms)
    }

    private fun initializeObservers() {
        termsViewModel.state.observe(this, Observer<TermViewState> {
            when (it) {
                is TermViewState.TermStored -> updateTermsInAdapter(it.terms)
                is TermViewState.PrevThreeTermsStored -> Unit
            }
        })
        termsViewModel.getPrevThreeTermsStored()
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
    }

    private fun initializeViewEvents() {
        msHomeSearchInput?.apply {
            setOnClickListener {

            }
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
                    searchViewModel.searchMusic(query.toString())
                    return true
                }
            })

            setOnFocusChangeListener(object : SearchLayout.OnFocusChangeListener {
                override fun onFocusChange(hasFocus: Boolean) {
                    navigationIconSupport = if (hasFocus) {
                        termsViewModel.getAllTermsStored()
                        SearchLayout.NavigationIconSupport.ARROW
                    } else{
                        termsAdapter.clearAndAddAll(emptyList())
                        SearchLayout.NavigationIconSupport.NONE
                    }
                }
            })
        }

    }

    override fun doOnTermSelected(term: String) {

    }

}