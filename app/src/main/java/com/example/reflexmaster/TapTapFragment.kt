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
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController

class TapTapFragment : Fragment() {

    private val viewModel: TapTapViewModel by viewModels()

    var height1 = 0;
    var width1 = 0;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        naciajHodnoty()

        return inflater.inflate(R.layout.fragment_tap_tap, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textViewScore = view.findViewById<TextView>(R.id.tv_score)
        val constraintLayout = view.findViewById<ConstraintLayout>(R.id.vedla)
        // po prevrateni
        textViewScore.text = viewModel.score.toString()
        constraintLayout.setOnClickListener {
            viewModel.gameOver()
            view.findNavController().navigate(R.id.action_tapTapFragment_to_gameOverFragment)
            // kód, ktorý sa vykoná po kliknutí na ConstraintLayout
        }
        val btncircle: Button = view.findViewById(R.id.btn_circle)

        btncircle.setOnClickListener {
          // stlacenie tlacidla
            viewModel.increaseScore()
            textViewScore.text = viewModel.score.toString()

            var pox = viewModel.dajRandomX(width1).toFloat()
            btncircle.x = pox
            Log.d("Pozicia", "sirka: " + pox)
            var poy = viewModel.dajRandomY(height1).toFloat()
            btncircle.y = poy
            Log.d("Pozicia", "vyska: " + poy)
        }
    }

    fun naciajHodnoty() {
        val displayMetrics = Resources.getSystem().displayMetrics
        height1 = displayMetrics.heightPixels
        width1 = displayMetrics.widthPixels
    }

}