package com.example.weatherapiapplication.domain.weatherModel

import androidx.room.Entity
import com.google.gson.annotations.SerializedName


data class Cloud(

    @SerializedName("all")
    val cloudPercent: Int
)
