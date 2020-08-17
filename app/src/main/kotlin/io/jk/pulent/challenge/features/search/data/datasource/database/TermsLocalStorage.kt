package io.jk.pulent.challenge.features.search.data.datasource.database

import io.jk.pulent.challenge.core.db.PulentChallengeDataBase.Companion.room
import io.jk.pulent.challenge.features.search.data.datasource.database.dao.TermsHistoryDao
import io.jk.pulent.challenge.features.search.data.datasource.database.entity.TermEntity

class TermsLocalStorage {

    private val dao: TermsHistoryDao by lazy {
        requireNotNull(room.termsHistoryDao())
    }

    fun saveTerm(term: TermEntity) {
        dao.insert(term)
    }

    fun getTermsHistory(): List<TermEntity> {
        return dao.getAllTermsUsedByUser()
    }

}