package com.example.reflexmaster.database

import android.app.Application
import android.text.method.TextKeyListener.clear
import android.util.Log
import androidx.lifecycle.*
import androidx.room.RoomDatabase
import com.example.reflexmaster.formatNights
import kotlinx.coroutines.launch

class DatabaseViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ScoreRepository
    private var readAll : LiveData<List<Score>>

    private var _posledne = 0
    val posledne: Int
        get() = _posledne

    private var lastScore = MutableLiveData<Score?>()

    init {
        val scoreDB = ScoreDatabase.getInstance(application).scoreDatabaseDao
        repository = ScoreRepository(scoreDB)
        readAll = repository.getAllScore()
        initializeLast()
    }

    private val scr = repository.getAllScore()

    val scoreStrings = Transformations.map(scr) { scr ->
        formatNights(scr, application.resources)
    }

    fun initializeLast() {
        viewModelScope.launch {
            lastScore.value = repository.getTonightFromDatabase()
        }
    }

    fun dajPosledneScore(): Int {
        viewModelScope.launch {
            _posledne = repository.getLastScR()!!
            Log.d("Databaza", "scre: " + repository.getLastScR())   //6
        }
        return _posledne
    }

    fun pridajScore(score: Score){
        viewModelScope.launch {
            repository.insert(score)
        }
    }

    fun onClear() {
        viewModelScope.launch {
            repository.clear()
            lastScore.value  = null
        }
    }

}