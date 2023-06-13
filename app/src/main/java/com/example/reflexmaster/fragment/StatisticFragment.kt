package com.example.reflexmaster.fragment

import android.graphics.Typeface
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.reflexmaster.R
import com.example.reflexmaster.Timer
import com.example.reflexmaster.Timer2
import com.example.reflexmaster.convertLongToDateString
import com.example.reflexmaster.database.DatabaseViewModel


class StatisticFragment : Fragment() {

    private val viewModelDb: DatabaseViewModel by viewModels()
    private lateinit var timer2: Timer2
    private lateinit var viewMaxSc: TextView
    private lateinit var viewMinSc: TextView
    private lateinit var viewAvgSc: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_statistic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        timer2 = Timer2(600, 50, this)

        // Spustenie časovača
        timer2.start()

        viewMaxSc = view.findViewById(R.id.txtNaj)
        viewMinSc = view.findViewById(R.id.txtMin)
        viewAvgSc = view.findViewById(R.id.txtAvg)

        viewMaxSc.setTypeface(null, Typeface.BOLD)
        viewMinSc.setTypeface(null, Typeface.BOLD)
        viewAvgSc.setTypeface(null, Typeface.BOLD)

        viewMaxSc.text = viewModelDb.dajMaxScore().score.toString() + " Čas: " + convertLongToDateString(viewModelDb.dajMaxScore().timeMilli)
        viewMinSc.text = viewModelDb.dajMinScore().score.toString() + " Čas: " + convertLongToDateString(viewModelDb.dajMinScore().timeMilli)
        viewAvgSc.text = viewModelDb.dajAvgScore().toString()
    }

    fun onTimerFinish() {
        // Táto metóda sa volá po skončení časovača
        // Môžete sem vložiť kód na vykonanie akcií po skončení časovača
        Log.d("casovac", "skoncil som")
        viewMaxSc.text = viewModelDb.dajMaxScore().score.toString() + " Čas: " + convertLongToDateString(viewModelDb.dajMaxScore().timeMilli)
        viewMinSc.text = viewModelDb.dajMinScore().score.toString() + " Čas: " + convertLongToDateString(viewModelDb.dajMinScore().timeMilli)
        viewAvgSc.text = viewModelDb.dajAvgScore().toString()
    }
}