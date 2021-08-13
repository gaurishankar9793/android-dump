package com.example.my.currentData

import androidx.lifecycle.ViewModel
import com.example.my.MainRepository

class CurrentViewViewModel(
    private val repository : MainRepository
) : ViewModel() {
    // TODO: Implement the ViewModel
    val weather = repository.getCurrentWeather(10.0,10.0)

}