package com.example.reflexmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController

class MenuFragment : Fragment() {

    private val viewModel: MenuViewModel by viewModels()
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