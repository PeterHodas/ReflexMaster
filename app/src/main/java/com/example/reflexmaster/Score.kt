package com.example.reflexmaster

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "score_table")
data class Score(
    @PrimaryKey(autoGenerate = true)
    var scoreID: Long = 0L,

    @ColumnInfo(name = "score_clm")
    var score: Int = -1
)