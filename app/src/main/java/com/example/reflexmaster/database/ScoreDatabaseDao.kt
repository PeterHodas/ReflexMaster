package com.example.reflexmaster.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface ScoreDatabaseDao {
    @Insert
    suspend fun insert(score: Score)

    @Update
    suspend fun update(score: Score)

    @Query("SELECT * from score_table1 WHERE scoreID = :key")
    suspend fun get(key: Long): Score?

    @Query("DELETE FROM score_table1")
    suspend fun clear()

    @Query("SELECT * FROM score_table1 ORDER BY time_milli DESC LIMIT 1")
    suspend fun getTonight(): Score?

    @Query("SELECT * FROM score_table1 ORDER BY scoreID DESC")
    fun getAllNights(): LiveData<List<Score>>

    @Query("SELECT score_clm FROM score_table1 ORDER BY time_milli DESC LIMIT 1")
    suspend fun getLastSc(): Int?

    @Query("SELECT * FROM score_table1 ORDER BY score_clm ASC LIMIT 1 ")
    suspend fun getMaxScore(): Score?

    @Query("SELECT * FROM score_table1 ORDER BY score_clm DESC LIMIT 1 ")
    suspend fun getMinScore(): Score?

    @Query("SELECT avg(score_clm) FROM score_table1 ")
    suspend fun getAvgScore(): Int?

}