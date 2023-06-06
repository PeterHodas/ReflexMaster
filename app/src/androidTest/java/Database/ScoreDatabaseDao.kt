package Database

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

    @Query("SELECT * from score_table WHERE scoreID = :key")
    suspend fun get(key: Long): Score?

    @Query("DELETE FROM score_table")
    suspend fun clear()

    @Query("SELECT * FROM score_table ORDER BY scoreID DESC LIMIT 1")
    suspend fun getTonight(): Score?

    @Query("SELECT * FROM score_table ORDER BY scoreID DESC")
    fun getAllNights(): LiveData<List<Score>>
}