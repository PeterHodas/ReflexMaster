package com.example.reflexmaster.viewModel

import android.app.Application
import android.provider.SyncStateContract.Helpers.insert
import android.text.method.TextKeyListener.clear
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.viewModelScope
import com.example.reflexmaster.database.Score
import com.example.reflexmaster.database.ScoreDatabaseDao
import com.example.reflexmaster.formatNights
import kotlinx.coroutines.launch

class StatisticViewModel {

}