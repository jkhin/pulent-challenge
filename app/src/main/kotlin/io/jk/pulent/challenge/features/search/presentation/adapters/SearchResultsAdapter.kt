package io.jk.pulent.challenge.features.search.presentation.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.jk.pulent.challenge.R
import io.jk.pulent.challenge.features.search.presentation.model.SongModel
import kotlinx.android.synthetic.main.item_view_song.view.*

class SearchResultsAdapter : RecyclerView.Adapter<SearchResultsAdapter.SongViewHolder>() {

    private val results: MutableList<SongModel> = mutableListOf()

    fun clearAndAddAll(items: List<SongModel>) {
        results.clear()
        results.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder =
        SongViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_view_song, parent, false)
        )

    override fun getItemCount() = results.size

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        holder.bind(results[position])
    }

    inner class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(songModel: SongModel) = with(itemView) {
            tvItemSongName?.text = songModel.trackName
            tvItemSongArtistName?.text = songModel.artistName
            ivItemSongImage?.setImageURI(songModel.artworkUrl60)
        }
    }

}