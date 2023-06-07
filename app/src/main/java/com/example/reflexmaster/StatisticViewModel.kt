package com.example.reflexmaster

import android.app.Application
import androidx.lifecycle.AndroidViewModel

class StatisticViewModel(val database: ScoreDatabaseDao,
                         application: Application): AndroidViewModel(application) {
}