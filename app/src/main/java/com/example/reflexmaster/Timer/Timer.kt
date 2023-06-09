package com.example.reflexmaster.Timer

import android.os.CountDownTimer
import com.example.reflexmaster.fragment.GameOverFragment

/**
 * Trieda z ktorej sa vytvára inštancia tiemra pre fragment GameOverFragment
 */
class Timer(duration: Long, interval: Long, private val callback: GameOverFragment) :
    CountDownTimer(duration, interval) {

    override fun onTick(millisUntilFinished: Long) {
        // Táto metóda sa volá pri každom tiknutí časovača
        // Môžete sem vložiť kód na aktualizáciu zobrazenia alebo vykonanie ďalších akcií
    }

    override fun onFinish() {
        // Táto metóda sa volá po skončení časovača
        // Môžete sem vložiť kód na vykonanie akcií po skončení časovača
        callback.onTimerFinish()
    }

    interface TimerCallback {
        fun onTimerFinish()
    }
}