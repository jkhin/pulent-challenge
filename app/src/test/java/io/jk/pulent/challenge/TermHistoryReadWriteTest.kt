package io.jk.pulent.challenge

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import io.jk.pulent.challenge.core.db.PulentChallengeDataBase
import io.jk.pulent.challenge.features.search.data.datasource.database.dao.TermsHistoryDao
import org.junit.After
import org.junit.Before
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class TermHistoryReadWriteTest {

    private lateinit var termsHistoryDao: TermsHistoryDao

    private lateinit var database: PulentChallengeDataBase

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        database = Room.inMemoryDatabaseBuilder(
            context, PulentChallengeDataBase::class.java).build()
        termsHistoryDao = database.termsHistoryDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        database.close()
    }

}