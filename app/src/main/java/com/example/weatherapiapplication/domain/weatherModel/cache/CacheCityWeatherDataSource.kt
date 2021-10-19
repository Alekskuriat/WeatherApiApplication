package com.example.weatherapiapplication.domain.weatherModel.cache

import com.example.weatherapiapplication.domain.di.modules.WeatherApiModel
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import com.example.weatherapiapplication.domain.weatherModel.data.CityWeatherDataSource
import io.reactivex.rxjava3.core.Single

interface CacheCityWeatherDataSource : CityWeatherDataSource {

    fun retain(cityName: String, weather: CityWeatherModel): Single<CityWeatherModel>

}