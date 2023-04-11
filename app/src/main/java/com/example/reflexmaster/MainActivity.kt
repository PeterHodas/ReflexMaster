package com.example.reflexmaster

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Pri spustení aktivity nastavíme prvý fragment ako aktívny
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, MainFragment())  //FirstFragment() -> MainFragment
            .commit()

        // Nastavíme OnClickListener pre tlačidlá na preklikávanie medzi fragmentmi
       /* button_first.setOnClickListener {
            replaceFragment(MainFragment())
        }

        button_second.setOnClickListener {
            replaceFragment(MenuFragment())
        }*/
    }

    // Nastavíme OnClickListener pre tlačidlá na preklikávanie medzi fragmentmi
    fun onButtonClick1(view: View) {
        replaceFragment(MainFragment())
    }

    fun onButtonClick2(view: View) {
        replaceFragment(MenuFragment())
    }

    // Funkcia pre nahradenie aktívneho fragmentu
    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}