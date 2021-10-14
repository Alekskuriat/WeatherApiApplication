package com.example.weatherapiapplication.domain.weatherModel

import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


@Entity(tableName = "city_weather")
data class CityWeatherModel(

    @PrimaryKey
    @SerializedName("id")
    val id : Int,

    @Embedded
    @SerializedName("main")
    val weatherMain: WeatherMain,

    @Embedded
    @SerializedName("wind")
    val wind: Wind,

    @Embedded
    @SerializedName("clouds")
    val clouds: Cloud,


)
