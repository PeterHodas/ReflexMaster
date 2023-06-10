package com.example.reflexmaster.database

import androidx.lifecycle.LiveData

class ScoreRepository(private val scoreDao: ScoreDatabaseDao) {

    suspend fun getTonightFromDatabase(): Score? {
        return scoreDao.getTonight()
    }

    suspend fun insert(score: Score) {
        scoreDao.insert(score)
    }

    suspend fun update(score: Score) {
        scoreDao.update(score)
    }

    suspend fun clear() {
        scoreDao.clear()
    }

    suspend fun getLastScR(): Int?{
        return scoreDao.getLastSc()
    }

    fun getAllScore(): LiveData<List<Score>> = scoreDao.getAllNights()
}