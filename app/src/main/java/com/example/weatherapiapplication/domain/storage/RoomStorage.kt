package com.example.weatherapiapplication.domain.storage

import androidx.room.AutoMigration
import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.city.dao.CityDao
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherEntity
import com.example.weatherapiapplication.domain.weatherModel.dao.CityWeatherDao

@Database(
    exportSchema = false,
    entities = [CityModel::class, CityWeatherEntity::class],
    version = 1
)
abstract class RoomStorage : RoomDatabase() {

    abstract fun getCityDao(): CityDao

    abstract fun getCityWeatherDao(): CityWeatherDao
}