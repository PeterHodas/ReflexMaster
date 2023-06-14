package com.example.reflexmaster.fragment

import android.content.res.Configuration
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import com.example.reflexmaster.R
import com.example.reflexmaster.viewModel.SemaforViewModel
import com.example.reflexmaster.viewModel.TapTapViewModel


class SemaforFragment : Fragment() {
    private val viewModel: SemaforViewModel by viewModels()
    private lateinit var countDownTimer: CountDownTimer
    private lateinit var txtTvoje: TextView
    private lateinit var buttonStop: Button
    private lateinit var buttonHome: Button
    private lateinit var buttonAgain: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_semafor, container, false)
    }


    var totalTime = 60000L // Total time in milliseconds (60 seconds)
    val interval = 10L // Interval in milliseconds (10 milisecond)

    var secondsPassed = 0L
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            viewModel.zmenStav()
            Log.d("Otocenie", " bol som otoceny xgwcjwvckbwckbhahahhahaahhahhahahah")
        } else {
            // Orientácia obrazovky je portrait (vertikálna)
            // Vykonajte príslušné akcie pre portrait orientáciu
        }

        val light1: Button = view.findViewById(R.id.light1)
        val light2: Button = view.findViewById(R.id.light2)
        val light3: Button = view.findViewById(R.id.light3)

        txtTvoje = view.findViewById(R.id.tvoje_score)
        val txtViewVarning: TextView = view.findViewById(R.id.waring)

        buttonStop = view.findViewById(R.id.btnStop)
        buttonAgain = view.findViewById(R.id.againSemafor)
        buttonHome = view.findViewById(R.id.homeSemafor)

        light1.isVisible = false
        light2.isVisible = false
        light3.isVisible = false
        txtTvoje.isVisible = false
        buttonAgain.isVisible = false
        buttonHome.isVisible = false
        txtViewVarning.isVisible = false

        var jeZhasnute = false
        val textViewSecond = view.findViewById<TextView>(R.id.sekundyTxt)

        countDownTimer = object : CountDownTimer(totalTime, interval) {
            override fun onTick(millisUntilFinished: Long) {
                if (viewModel.bolUzOtoceny == true) {
                    light1.isVisible = false
                    light2.isVisible = false
                    light3.isVisible = false
                    txtTvoje.isVisible = false
                    buttonAgain.isVisible = true
                    buttonHome.isVisible = true
                    buttonStop.isVisible = false
                    textViewSecond.isVisible = false
                    txtViewVarning.isVisible = true
                } else {
                    // Calculate elapsed seconds
                    secondsPassed = (totalTime - millisUntilFinished) // 1000



                    // Update UI with elapsed seconds
                    if (jeZhasnute == true) {
                        var cas = secondsPassed - 4000
                        textViewSecond.text = cas.toString()
                    }


                    if (secondsPassed > 1000 && secondsPassed < 1050){
                        light1.isVisible = true
                    } else if(secondsPassed > 2000 && secondsPassed < 2050){
                        light2.isVisible = true
                    } else if(secondsPassed > 3000 && secondsPassed < 3050){
                        light3.isVisible = true
                    } else if (secondsPassed > 4000 && secondsPassed < 4050) {
                        light1.isVisible = false
                        light2.isVisible = false
                        light3.isVisible = false
                        jeZhasnute = true
                        totalTime = 60000L
                    }
                }
            }

            override fun onFinish() {

            }
        }
        countDownTimer.start()

        buttonStop.setOnClickListener {
            if(jeZhasnute == true) {
                gameOver()
            } else {
                gameOver()
            }
        }

        buttonHome.setOnClickListener {
            view.findNavController().navigate(R.id.action_semaforFragment_to_menuFragment)
        }

        buttonAgain.setOnClickListener {
            view.findNavController().navigate(R.id.action_semaforFragment_self)
        }
    }

    fun gameOver() {
        countDownTimer.cancel()
        txtTvoje.isVisible = true
        buttonStop.isVisible = false
        buttonAgain.isVisible = true
        buttonHome.isVisible = true
    }
}