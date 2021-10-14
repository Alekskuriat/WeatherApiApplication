package com.example.weatherapiapplication.domain.api


import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("2.5/weather?")
    fun getWeatherCity(
        @Query("q") cityName: String,
        @Query("appid") apiKey : String = "46ecefd21bc6e54164835663ebe5ac6f"
    ): Single<CityWeatherModel>


}