package com.example.reflexmaster.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.reflexmaster.database.Score
import com.example.reflexmaster.database.ScoreDatabaseDao
import com.example.reflexmaster.formatNights
import kotlinx.coroutines.launch

class StatisticViewModel(val database: ScoreDatabaseDao,
                         application: Application): AndroidViewModel(application) {
    private val scr = database.getAllNights()

    val scoreStrings = Transformations.map(scr) { scr ->
        formatNights(scr, application.resources)
    }

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
            val newNight = Score(score = 22)
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