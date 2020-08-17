package io.jk.pulent.challenge.features.search.data.datasource.database.dao

import androidx.room.*
import io.jk.pulent.challenge.features.search.data.datasource.database.entity.TermEntity

@Dao
interface TermsHistoryDao {

    @Query("SELECT * FROM term_history_table ORDER BY createdAt ASC LIMIT 3")
    fun getPrevThreeTermsUsedByUser(): List<TermEntity>

    @Query("SELECT * FROM term_history_table ORDER BY createdAt DESC")
    fun getAllTermsUsedByUser(): List<TermEntity>

    @Delete
    fun deleteTerm(termHistoryEntity: TermEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(termHistoryEntity: TermEntity)

}