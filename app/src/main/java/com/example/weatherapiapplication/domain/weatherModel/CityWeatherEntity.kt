package com.example.weatherapiapplication.domain.weatherModel

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = CityWeatherEntity.TABLE_NAME)
data class CityWeatherEntity(

    @PrimaryKey
    val city: String,

    @ColumnInfo
    val temp: Double,

    @ColumnInfo
    val feelLike: Double,

    @ColumnInfo
    val tempMin: Double,

    @ColumnInfo
    val tempMax: Double,

    @ColumnInfo
    val pressure: Int,

    @ColumnInfo
    val humidity: Int,

    @ColumnInfo
    val windSpeed: Double,

    @ColumnInfo
    val windDeg: Int,

    @ColumnInfo
    val cloudPercent: Int
) {
    companion object {
        const val TABLE_NAME = "city_weather_table"
    }
}