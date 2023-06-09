package com.example.reflexmaster.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.reflexmaster.R
import com.example.reflexmaster.viewModel.StatisticViewModel
import com.example.reflexmaster.viewModelFactory.StatisticViewModelFactory
import com.example.reflexmaster.database.ScoreDatabase
import com.example.reflexmaster.databinding.FragmentStatisticBinding


class StatisticFragment : Fragment() {
    private val viewModel: StatisticViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Get a reference to the binding object and inflate the fragment views.
        val binding: FragmentStatisticBinding = DataBindingUtil.inflate(
            inflater, R.layout.fragment_statistic, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = ScoreDatabase.getInstance(application).scoreDatabaseDao

        val viewModelFactory = StatisticViewModelFactory(dataSource, application)

        val statisticViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(StatisticViewModel::class.java)

        binding.setLifecycleOwner(this)

        binding.statistic2ViewModel = statisticViewModel

        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_statistic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val btnDbdel: Button = view.findViewById(R.id.vymazBtnDb)

        btnDbdel.setOnClickListener {
            viewModel.onClear()
        }
    }
}