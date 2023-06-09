package com.example.reflexmaster.database

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.reflexmaster.formatNights
import kotlinx.coroutines.launch

/**
 *  Trieda ktorú som vytvoril aby sa databáza vytvorila iba raz
 *  a nemusel ju volať vzdy v kazdom fragmente a vytvárať si rovnaké funcie
 */

class DatabaseViewModel(application: Application): AndroidViewModel(application) {
    private val repository: ScoreRepository
    private var readAll : LiveData<List<Score>>

    private var _posledne = 0
    val posledne: Int
        get() = _posledne

    private var _hodnota = Score(score = 0)
    val hodnota: Score
        get() = _hodnota

    private var _min = Score(score = 0)
    val min: Score
        get() = _min

    private var _priemer = 0
    val priemer: Int
        get() = _priemer

    private var lastScore = MutableLiveData<Score?>()

    init {
        val scoreDB = ScoreDatabase.getInstance(application).scoreDatabaseDao
        repository = ScoreRepository(scoreDB)
        readAll = repository.getAllScore()
        initializeLast()
    }

    // vráti všetky score
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

    // insert do databázy
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

    // vráti maximálne scóre
    fun dajMaxScore(): Score {
        viewModelScope.launch {
            _hodnota = repository.getMaxScore()!!
            Log.d("Databaza Max", "scre: " + repository.getMaxScore())
        }
        return _hodnota
    }

    // vráti minimálne scóre
    fun dajMinScore(): Score {
        viewModelScope.launch {
            _min = repository.getMinScore()!!
        }
        return _min
    }

    // vráti priemerné scóre
    fun dajAvgScore(): Int {
        viewModelScope.launch {
            _priemer = repository.getAvgScore()!!
        }
        return _priemer
    }
}