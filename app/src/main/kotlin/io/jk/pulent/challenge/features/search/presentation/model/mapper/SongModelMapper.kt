package io.jk.pulent.challenge.features.search.presentation.model.mapper

import io.jk.pulent.challenge.features.search.domain.model.Song
import io.jk.pulent.challenge.features.search.presentation.model.SongModel

class SongModelMapper {
    fun map(response: Song): SongModel = with(response) {
        SongModel(
            artistId = artistId,
            artistName = artistName,
            artistViewUrl = artistViewUrl,
            artworkUrl100 = artworkUrl100,
            artworkUrl60 = artworkUrl60,
            collectionCensoredName = collectionCensoredName,
            collectionExplicitness = collectionExplicitness,
            collectionId = collectionId,
            collectionName = collectionName,
            collectionPrice = collectionPrice,
            collectionViewUrl = collectionViewUrl,
            country = country,
            currency = currency,
            discCount = discCount,
            discNumber = discNumber,
            kind = kind,
            previewUrl = previewUrl,
            primaryGenreName = primaryGenreName,
            trackCensoredName = trackCensoredName,
            trackCount = trackCount,
            trackExplicitness = trackExplicitness,
            trackId = trackId,
            trackName = trackName,
            trackNumber = trackNumber,
            trackPrice = trackPrice,
            trackTimeMillis = trackTimeMillis,
            trackViewUrl = trackViewUrl,
            wrapperType = wrapperType
        )
    }

}