package com.example.reflexmaster.viewModel

import android.app.Application
import android.content.res.Resources
import android.text.method.TextKeyListener.clear
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.reflexmaster.database.Score
import com.example.reflexmaster.database.ScoreDatabaseDao
import kotlinx.coroutines.launch

class TapTapViewModel (val database: ScoreDatabaseDao,
                       application: Application): AndroidViewModel(application) {

    private var _score = 0
    val score: Int
    get() = _score

    private var _height1 = 0
    val height1: Int
        get() = _height1

    private var _width1 = 0
    val width1: Int
        get() = _width1

    private var _pozX = 0
    val pozX: Float
        get() = _pozX.toFloat()

    private var _pozY = 0
    val pozY: Float
        get() = _pozY.toFloat()

    private suspend fun insert(score: Score) {
        database.insert(score)
    }

    fun ulozSkore(score: Score) {
        viewModelScope.launch {
            insert(score)
        }
    }

    fun increaseScore() {
        _score += 1
    }

    override fun onCleared() {
        super.onCleared()
        Log.d("TapTapFragment", "TapTapViewModel destroyed!")
    }

    fun dajRandomX(maxX: Int): Int {
        return (30..maxX-((maxX/100)*21)).random()
    }

    fun dajRandomY(maxY: Int): Int {
        return (100..maxY-((maxY/100)*20)).random()
    }

    fun gameOver() {

    }

    fun dajPolohuX() {
        _pozX = dajRandomX(width1)
    }

    fun dajPolohuY() {
        _pozY = dajRandomY(height1)
    }

    fun naciajHodnoty() {
        val displayMetrics = Resources.getSystem().displayMetrics
        _height1 = displayMetrics.heightPixels
        _width1 = displayMetrics.widthPixels
    }
}