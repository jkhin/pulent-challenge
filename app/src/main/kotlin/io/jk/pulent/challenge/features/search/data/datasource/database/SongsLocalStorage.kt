package io.jk.pulent.challenge.features.search.data.datasource.database

import io.jk.pulent.challenge.core.db.PulentChallengeDataBase.Companion.room
import io.jk.pulent.challenge.features.search.data.datasource.database.dao.SongsDao
import io.jk.pulent.challenge.features.search.data.datasource.database.entity.SongEntity

class SongsLocalStorage {

    private val dao: SongsDao by lazy {
        requireNotNull(room.songsDao())
    }

    fun getSongs(term: String): List<SongEntity> {
        return dao.getSongs(term)
    }

    suspend fun insertAllSongs(songs: List<SongEntity>) {
        dao.insertSongs(songs)
    }

}