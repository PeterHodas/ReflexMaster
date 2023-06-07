package com.example.reflexmaster

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider


class StatisticFragment : Fragment() {

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
        val binding: FragmentSta = DataBindingUtil.inflate(
            inflater, R.layout.fragment_statistic, container, false)

        val application = requireNotNull(this.activity).application

        val dataSource = ScoreDatabase.getInstance(application).scoreDatabaseDao

        val viewModelFactory = StatisticViewModelFactory(dataSource, application)

        val scoreViewModel =
            ViewModelProvider(
                this, viewModelFactory).get(StatisticViewModel::class.java)

        binding.setLifecycleOwner(this)
        binding.scoreViewModel = scoreViewModel

        return binding.root
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_statistic, container, false)
    }
}