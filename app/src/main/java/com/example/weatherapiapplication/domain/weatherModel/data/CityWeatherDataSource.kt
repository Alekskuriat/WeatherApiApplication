package com.example.weatherapiapplication.domain.weatherModel.data

import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import io.reactivex.rxjava3.core.Single

interface CityWeatherDataSource {

    fun getWeather(cityName: String): Single<CityWeatherModel>
}