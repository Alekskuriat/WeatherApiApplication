package com.example.weatherapiapplication.domain.storage

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.city.dao.CityDao
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import com.example.weatherapiapplication.domain.weatherModel.dao.CityWeatherDao

@Database(
    exportSchema = false,
    entities = [CityModel::class, CityWeatherModel::class],
    version = 1
)
abstract class WeatherStorage : RoomDatabase() {

    abstract fun getCityDao(): CityDao

    abstract fun getCityWeatherDao(): CityWeatherDao
}