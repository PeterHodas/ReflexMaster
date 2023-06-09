package com.example.reflexmaster.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "score_table1")
data class Score(
    @PrimaryKey(autoGenerate = true)
    var scoreID: Long = 0L,

    @ColumnInfo(name = "time_milli")
    val timeMilli: Long = System.currentTimeMillis(),

    @ColumnInfo(name = "score_clm")
    var score: Int = -1
)