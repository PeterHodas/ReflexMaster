package com.example.reflexmaster

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
class StatisticViewModel(val database: ScoreDatabaseDao,
                         application: Application): AndroidViewModel(application) {
    private val scr = database.getAllNights()


    private var lastScore = MutableLiveData<Score?>()

    init {
        initializeLast()
    }

    private fun initializeLast() {
        viewModelScope.launch {
            lastScore.value = getTonightFromDatabase()
        }
    }

    private suspend fun getTonightFromDatabase(): Score? {
        return database.getTonight()
    }

    private suspend fun insert(score: Score) {
        database.insert(score)
    }

    private suspend fun update(score: Score) {
        database.update(score)
    }

    fun onStartTracking() {
        viewModelScope.launch {
            val newNight = Score(2)
            insert(newNight)
            lastScore.value = getTonightFromDatabase()
        }
    }

    fun onClear() {
        viewModelScope.launch {
            clear()
            lastScore.value = null
        }
    }

    suspend fun clear() {
        database.clear()
    }


}