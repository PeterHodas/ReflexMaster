package com.example.reflexmaster.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.reflexmaster.R
import com.example.reflexmaster.Timer.Timer
import com.example.reflexmaster.database.DatabaseViewModel

/**
 * Trieda ktorá riadni fragment ktorý sa objaví po ukončení hry Tap Tap
 * vytvorí si inštanciu buttonov a načíta dáta z databázy
 */
class GameOverFragment : Fragment() {
    private lateinit var timer: Timer
    private val viewModelDb: DatabaseViewModel by viewModels()
    private lateinit var viewScre: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_over, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // vytvorenie inštancii buttonov a view
        viewScre = view.findViewById(R.id.scoreAktual)
        val btnHome: Button = view.findViewById(R.id.BtnHome)
        val btnAgain: Button = view.findViewById(R.id.BtnAgain)

        Log.d("vykonane", "idem: " )   //6

        btnHome.setOnClickListener {
            view.findNavController().navigate(R.id.action_gameOverFragment_to_menuFragment)
        }

        btnAgain.setOnClickListener {
            view.findNavController().navigate(R.id.action_gameOverFragment_to_tapTapFragment)
        }

        // Vytvorenie inštancie timeru s trvaním 2,5 sekúnd a intervalom 1 sekundy
        timer = Timer(250, 50, this)

        // Spustenie časovača
        timer.start()
        Log.d("pred txViw", viewModelDb.dajPosledneScore().toString() )
        viewScre.text = viewModelDb.dajPosledneScore().toString()
    }

    fun onTimerFinish() {
        // Táto metóda sa volá po skončení časovača
        // Môžete sem vložiť kód na vykonanie akcií po skončení časovača
        Log.d("casovac", "Presla doba")
        viewScre.text = viewModelDb.dajPosledneScore().toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Zastavenie časovača pri zničení fragmentu
        timer.cancel()
    }
}