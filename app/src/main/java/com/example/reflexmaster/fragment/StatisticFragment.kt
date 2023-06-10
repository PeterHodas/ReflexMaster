package com.example.reflexmaster.fragment

import android.os.Bundle
import android.text.Html
import android.text.Spanned
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.reflexmaster.R
import com.example.reflexmaster.database.DatabaseViewModel
import com.example.reflexmaster.database.Score
import com.example.reflexmaster.viewModel.TapTapViewModel


class StatisticFragment : Fragment() {

    private val viewModelDb: DatabaseViewModel by viewModels()
    private var aktScore = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            viewModelDb.dajPosledneScore()
            //aktScore = viewModelDb.posledne
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModelDb.dajPosledneScore()
        //aktScore = viewModelDb.posledne
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_statistic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnDbdel: Button = view.findViewById(R.id.vymazBtnDb)

        val txtDB: TextView = view.findViewById(R.id.db_txtv)
        //txtDB.text = viewModelDb.dajPosledneScore().toString()
        //txtDB.text = viewModelDb.scoreStrings
        viewModelDb.dajPosledneScore()
        //aktScore = viewModelDb.posledne
        txtDB.text = aktScore.toString()


        btnDbdel.setOnClickListener {
            //viewModel.onClear()
            viewModelDb.onClear()
        }
    }
}