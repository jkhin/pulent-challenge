package io.jk.pulent.challenge.features.search.data.mapper

import io.jk.pulent.challenge.features.search.data.datasource.database.entity.SongEntity
import io.jk.pulent.challenge.features.search.data.datasource.rest.response.SongResponse

class SongEntityMapper {
    fun map(response: SongResponse): SongEntity = with(response) {
        SongEntity(
            id = Long.MAX_VALUE,
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