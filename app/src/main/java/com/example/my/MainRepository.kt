package com.example.my

import com.example.my.currentData.CurrentData

class MainRepository constructor(private val retrofitservice : RetroFitService) {




    fun getCurrentWeather(lat:Double,long:Double)
            = retrofitservice.getCurrentWeather(lat,long)


}