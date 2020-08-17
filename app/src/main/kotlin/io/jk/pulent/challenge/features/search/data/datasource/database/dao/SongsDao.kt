package io.jk.pulent.challenge.features.search.data.datasource.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.jk.pulent.challenge.features.search.data.datasource.database.entity.SongEntity

@Dao
interface SongsDao {

    @Query("SELECT * from song_table WHERE trackName LIKE :term")
    fun getSongs(term: String): List<SongEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSongs(songs: List<SongEntity>)

}