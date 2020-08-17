package io.jk.pulent.challenge.core.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import io.jk.pulent.challenge.features.search.data.datasource.database.dao.SongsDao
import io.jk.pulent.challenge.features.search.data.datasource.database.dao.TermsHistoryDao
import io.jk.pulent.challenge.features.search.data.datasource.database.entity.SongEntity
import io.jk.pulent.challenge.features.search.data.datasource.database.entity.TermEntity


@Database(
    entities = [TermEntity::class, SongEntity::class],
    version = 1,
    exportSchema = false
)
abstract class PulentChallengeDataBase : RoomDatabase() {

    abstract fun songsDao(): SongsDao

    abstract fun termsHistoryDao(): TermsHistoryDao

    companion object {
        @Volatile
        lateinit var room: PulentChallengeDataBase

        fun initializeDatabase(context: Context) {

            if (::room.isInitialized) return

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    PulentChallengeDataBase::class.java,
                    "pulent_challenge_database"
                ).build()
                room = instance
            }
        }

    }
}

object DB {
    fun init(context: Context) {

    }
}