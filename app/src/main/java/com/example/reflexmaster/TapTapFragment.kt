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
import android.content.res.Configuration


class TapTapFragment : Fragment() {

    private val viewModel: TapTapViewModel by viewModels()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.naciajHodnoty()

        return inflater.inflate(R.layout.fragment_tap_tap, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textViewScore = view.findViewById<TextView>(R.id.tv_score)
        val constraintLayout = view.findViewById<ConstraintLayout>(R.id.vedla)
        val btncircle: Button = view.findViewById(R.id.btn_circle)

        // po prevrateni
        textViewScore.text = viewModel.score.toString()
        btncircle.x = viewModel.pozX
        btncircle.y  = viewModel.pozY

        if(viewModel.pozX == 0F && viewModel.pozY == 0F){
            viewModel.dajPolohuX()
            btncircle.x = viewModel.pozX

            viewModel.dajPolohuY()
            btncircle.y = viewModel.pozY
        }


        constraintLayout.setOnClickListener {

            val currentOrientation = resources.configuration.orientation
            if (currentOrientation == Configuration.ORIENTATION_PORTRAIT) {
                // Aktuálny režim zobrazenia je Portrait (zvislý)
                // Tu môžete vykonať príslušné akcie pre tento režim
                viewModel.gameOver()
                view.findNavController().navigate(R.id.action_tapTapFragment_to_gameOverFragment)
            } else if (currentOrientation == Configuration.ORIENTATION_LANDSCAPE) {
                // Aktuálny režim zobrazenia je Landscape (vodorovný)
                // Tu môžete vykonať príslušné akcie pre tento režim
            }

            // kód, ktorý sa vykoná po kliknutí na ConstraintLayout
        }


        btncircle.setOnClickListener {
          // stlacenie tlacidla
            viewModel.increaseScore()
            textViewScore.text = viewModel.score.toString()

            viewModel.dajPolohuX()
            btncircle.x = viewModel.pozX
            Log.d("Pozicia", "sirka: " + viewModel.pozX)

            viewModel.dajPolohuY()
            btncircle.y = viewModel.pozY
            Log.d("Pozicia", "sirka: " + viewModel.pozY)
        }
    }

}