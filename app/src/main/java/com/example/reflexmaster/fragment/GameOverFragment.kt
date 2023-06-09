package com.example.reflexmaster.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import com.example.reflexmaster.R
import com.example.reflexmaster.Timer


class GameOverFragment : Fragment() {
    private lateinit var timer: Timer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_game_over, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val btnstart: Button = view.findViewById(R.id.startbt)
        val viewTime: TextView = view.findViewById(R.id.timeview)

        // Vytvorenie inštancie timeru s trvaním 10 sekúnd a intervalom 1 sekundy
        timer = Timer(10000, 1000, this)

        // Spustenie časovača
        timer.start()

        btnstart.setOnClickListener {
            viewTime.text = "Čas zostávajúci:  / 1000 sekúnd";
        }

    }

    fun onTimerFinish() {
        // Táto metóda sa volá po skončení časovača
        // Môžete sem vložiť kód na vykonanie akcií po skončení časovača
        Log.d("casovac", "Presla doba")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        // Zastavenie časovača pri zničení fragmentu
        timer.cancel()
    }


}