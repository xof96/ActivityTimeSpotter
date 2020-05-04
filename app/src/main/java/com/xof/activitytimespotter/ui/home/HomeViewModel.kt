package com.xof.activitytimespotter.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Ayer, Sábado 2 Mayo 2020"
    }
    val text: LiveData<String> = _text
}