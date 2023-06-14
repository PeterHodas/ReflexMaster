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
 * Trieda ktorá riadi a odchytáva stláčanie buttonov a preklikávanie na inú page
 */

class GameMenuFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_game_menu, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btntap: Button = view.findViewById(R.id.btn_tap)

        btntap.setOnClickListener {
            view.findNavController().navigate(R.id.action_gameMenuFragment_to_tapTapFragment)
        }

        val btnsemafor: Button = view.findViewById(R.id.btn_semafor)

        btnsemafor.setOnClickListener {
            view.findNavController().navigate(R.id.action_gameMenuFragment_to_semaforFragment)
        }
    }
}