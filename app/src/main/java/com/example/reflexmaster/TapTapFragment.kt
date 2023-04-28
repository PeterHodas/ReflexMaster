package com.example.reflexmaster

import android.content.res.Resources
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.findNavController

class TapTapFragment : Fragment() {

    var height1 = 0;
    var width1 = 0;
    var score = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val displayMetrics = Resources.getSystem().displayMetrics
        height1 = displayMetrics.heightPixels
        width1 = displayMetrics.widthPixels


        return inflater.inflate(R.layout.fragment_tap_tap, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val constraintLayout = view.findViewById<ConstraintLayout>(R.id.vedla)

        constraintLayout.setOnClickListener {
            view.findNavController().navigate(R.id.action_tapTapFragment_to_gameOverFragment)
            gameOver()
            // kód, ktorý sa vykoná po kliknutí na ConstraintLayout

        }

        //val myTextView = view.findViewById<TextView>(R.id.tv_score)
        //myTextView.text = "Vitajte v mojej aplikácii!"
        val btncircle: Button = view.findViewById(R.id.btn_circle)

        btncircle.setOnClickListener {
          // stlacenie tlacidla
            score++
            //myTextView.text(score)
            var pox =  dajRandomX(width1).toFloat()
            btncircle.x = pox
            Log.d("Pozicia", "sirka: " + pox)
            var poy = dajRandomY(height1).toFloat()
            btncircle.y = poy
            Log.d("Pozicia", "vyska: " + poy)
        }
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