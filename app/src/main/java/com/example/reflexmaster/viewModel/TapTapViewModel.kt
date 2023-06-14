package com.example.reflexmaster.viewModel

import android.content.res.Resources
import android.util.Log
import androidx.lifecycle.ViewModel


/**
 * ViewModel pre triedu TapTapFragment, uchováva premenne score, výška, šírka a robí funkcie
 * ako pripočítanie score, načítanie hodnôt a podobne
 */
class TapTapViewModel: ViewModel() {

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