package com.example.weatherapiapplication.domain.weatherModel.cache

import com.example.weatherapiapplication.domain.di.modules.WeatherApiModel
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherEntity
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import com.example.weatherapiapplication.domain.weatherModel.data.CityWeatherDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface CacheCityWeatherDataSource {

    fun getWeather(cityName: String): Single<CityWeatherEntity>
    fun saveWeatherCity(cityName: String, weather: CityWeatherModel): Completable

}