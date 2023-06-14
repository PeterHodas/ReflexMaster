package com.example.reflexmaster.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import com.example.reflexmaster.R

/**
 * Vytvorí inštancie buttonov a po kliknutí presunie na inú page
 */
class MenuFragment : Fragment() {

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
        return inflater.inflate(R.layout.fragment_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // odchytenie buttonov a nacitanie page podla kliknutia
        val btnvys: Button = view.findViewById(R.id.btn_vysledok)

        btnvys.setOnClickListener {
            view.findNavController().navigate(R.id.action_menuFragment_to_statisticFragment)
        }

        val btnhra: Button = view.findViewById(R.id.btn_trening)

        btnhra.setOnClickListener {
            view.findNavController().navigate(R.id.action_menuFragment_to_gameMenuFragment)
        }
    }

}