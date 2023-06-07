package com.example.reflexmaster

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class StatisticViewModelFactory(
    private val dataSource: ScoreDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory  {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StatisticViewModel::class.java)) {
            return StatisticViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}