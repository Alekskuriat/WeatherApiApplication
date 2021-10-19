package com.example.weatherapiapplication.domain.weatherModel.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.weatherModel.*
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single


@Dao
interface CityWeatherDao {

    @Query("SELECT * FROM city_weather")
    fun getWeatherCity(): Single<CityWeatherModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(weather: CityWeatherModel): Completable
}










