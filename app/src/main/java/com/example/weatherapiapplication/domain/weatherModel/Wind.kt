package com.example.weatherapiapplication.domain.weatherModel

import androidx.room.Entity
import com.google.gson.annotations.SerializedName


data class Wind(

    @SerializedName("speed")
    val windSpeed : Double,

    @SerializedName("deg")
    val windDeg : Int
)
