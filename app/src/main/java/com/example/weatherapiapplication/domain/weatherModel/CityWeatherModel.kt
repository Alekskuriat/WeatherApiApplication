package com.example.weatherapiapplication.domain.weatherModel

import com.google.gson.annotations.SerializedName
import com.google.gson.annotations.Until



data class CityWeatherModel(

    @SerializedName("id")
    val id : Int,

    @SerializedName("main")
    val weatherMain: WeatherMain,

    @SerializedName("wind")
    val wind: Wind,

    @SerializedName("clouds")
    val clouds: Cloud,

)
