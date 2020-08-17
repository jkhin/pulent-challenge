package io.jk.pulent.challenge.features.search.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.jk.pulent.challenge.R
import io.jk.pulent.challenge.features.home.presentation.model.TermHistoryModel
import kotlinx.android.synthetic.main.item_view_search_term_history.view.*

class TermsHistoryAdapter(
    private val listener: Listener
) : RecyclerView.Adapter<TermsHistoryAdapter.TermViewHolder>() {

    private val terms: MutableList<TermHistoryModel> = mutableListOf()

    private var termsToBeShown: MutableList<TermHistoryModel> = mutableListOf()

    private var tempTerms: List<TermHistoryModel> = emptyList()

    interface Listener {
        fun doOnTermSelected(term: String)
    }

    fun clearAndAddAll(items: List<TermHistoryModel>) {
        terms.clear()
        termsToBeShown.clear()
        terms.addAll(items)
        termsToBeShown.addAll(items)
        notifyDataSetChanged()
    }

    private fun clearFilterAndShowAll() {
        termsToBeShown.clear()
        termsToBeShown.addAll(terms)
        notifyDataSetChanged()
    }

    private fun clearAndAddAllOnFilter(items: List<TermHistoryModel>) {
        termsToBeShown.clear()
        termsToBeShown.addAll(items)
        notifyDataSetChanged()
    }

    fun filter(term: String) {
        tempTerms = terms
        clearAndAddAllOnFilter(tempTerms.filter { it.term.contains(term) })
    }

    fun clearFilter() {
        tempTerms = terms
        clearFilterAndShowAll()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TermViewHolder =
        TermViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view_search_term_history, parent, false)
        )

    override fun getItemCount() = termsToBeShown.size

    override fun onBindViewHolder(holder: TermViewHolder, position: Int) {
        holder.bind(termsToBeShown[position])
    }

    inner class TermViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(model: TermHistoryModel) = with(itemView) {
            setOnClickListener {
                if (adapterPosition < 0) return@setOnClickListener
                listener.doOnTermSelected(model.term)
            }
            tvItemTerm?.text = model.term
        }
    }

}