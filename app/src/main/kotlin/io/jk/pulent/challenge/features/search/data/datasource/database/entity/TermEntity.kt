package io.jk.pulent.challenge.features.search.data.datasource.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "term_history_table")
data class TermEntity(
    @PrimaryKey
    @ColumnInfo(name = "term")
    val term: String,
    @ColumnInfo(name = "createdAt")
    val createdAt: Long?
)