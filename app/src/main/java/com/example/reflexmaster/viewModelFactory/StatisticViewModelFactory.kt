package com.example.reflexmaster.viewModelFactory

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.reflexmaster.database.ScoreDatabaseDao
import com.example.reflexmaster.viewModel.StatisticViewModel

class StatisticViewModelFactory(
    private val dataSource: ScoreDatabaseDao,
    private val application: Application
) : ViewModelProvider.Factory  {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StatisticViewModel::class.java)) {
            return StatisticViewModel(dataSource, application) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}