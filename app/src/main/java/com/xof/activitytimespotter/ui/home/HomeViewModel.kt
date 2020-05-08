package com.xof.activitytimespotter.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _yesterdayDateText = MutableLiveData<String>().apply {
        value = "Ayer, Sábado 2 Mayo 2020"
    }
    val yesterdayDateText: LiveData<String> = _yesterdayDateText

    private val _todayDateText = MutableLiveData<String>().apply {
        value = "Hoy, Domingo 3 Mayo 2020"
    }
    val todayDateText: LiveData<String>
        get() = _todayDateText

    private val _yesterdayTasksNames = MutableLiveData<MutableList<String>>().apply {
        value = mutableListOf<String>("Dormir", "Jugar COD Warzone")
    }
    val yesterdayTasksNames: LiveData<MutableList<String>> = _yesterdayTasksNames

    private val _yesterdayTasksTimes = MutableLiveData<MutableList<String>>().apply {
        value = mutableListOf<String>("6h34m34s", "1h18m34s")
    }
    val yesterdayTasksTimes: LiveData<MutableList<String>>
        get() = _yesterdayTasksTimes
}