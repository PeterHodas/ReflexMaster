package com.example.reflexmaster.database

import androidx.lifecycle.LiveData

/**
 * V tejto triede su všetky funkcie s ktorými vieme pracovať s databázou po kope
 */
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

    // posledné score
    suspend fun getLastScR(): Int?{
        return scoreDao.getLastSc()
    }

    // všetky score
    fun getAllScore(): LiveData<List<Score>> = scoreDao.getAllNights()

    // maximalne score
    suspend fun getMaxScore(): Score? {
        return scoreDao.getMaxScore()
    }

    // minimalne score
    suspend fun getMinScore(): Score? {
        return scoreDao.getMinScore()
    }

    // priemerne score
    suspend fun getAvgScore(): Int? {
        return scoreDao.getAvgScore()
    }

}