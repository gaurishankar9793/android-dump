package com.example.my

import com.example.my.currentData.CurrentData
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import kotlinx.coroutines.Deferred
import retrofit2.http.GET
import retrofit2.http.Query
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val  API_KEY = "7ebaa839de68b76f9dfa66d483132d8a"

interface RetroFitService {

    @GET("/weather?")
     fun getCurrentWeather(
        @Query("lat") latitude: Double,
        @Query("lon") longitude: Double,
        @Query( "apiid")  apiid :String = API_KEY
    ) : Call<List<CurrentData>>
    companion object{
        var retrofitService: RetroFitService? = null

        fun getInstance() :RetroFitService {

            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl("api.openweathermap.org/data/2.5/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetroFitService::class.java)
            }
            return retrofitService!!
        }


    }


}