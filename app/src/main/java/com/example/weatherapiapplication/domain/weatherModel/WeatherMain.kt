package com.example.weatherapiapplication.domain.weatherModel

import androidx.room.Entity
import com.google.gson.annotations.SerializedName


data class WeatherMain(

    @SerializedName("temp")
    val temp : Double,

    @SerializedName("feels_like")
    val feelLike : Double,

    @SerializedName("temp_min")
    val tempMin : Double,

    @SerializedName("temp_max")
    val tempMax : Double,

    @SerializedName("pressure")
    val pressure : Int,

    @SerializedName("humidity")
    val humidity: Int

)


