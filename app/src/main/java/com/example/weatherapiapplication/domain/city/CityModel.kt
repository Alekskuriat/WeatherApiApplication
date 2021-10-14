package com.example.weatherapiapplication.domain.city

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel


@Entity(tableName = "cities")
data class CityModel(

    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "nameRU")
    val nameRU: String,
    @ColumnInfo(name = "lat")
    val lat: Double,
    @ColumnInfo(name = "lon")
    val lon: Double,



)




