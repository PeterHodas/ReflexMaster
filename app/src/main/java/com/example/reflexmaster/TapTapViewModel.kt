package com.example.reflexmaster

import android.util.Log
import androidx.lifecycle.ViewModel

class TapTapViewModel : ViewModel() {

    private var _score = 0
    val score: Int
    get() = _score

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
}