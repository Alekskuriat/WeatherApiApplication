package com.example.weatherapiapplication.domain.weatherModel.data

import com.example.weatherapiapplication.BuildConfig
import com.example.weatherapiapplication.domain.api.WeatherApi
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CityWeatherDataSourceImpl
@Inject constructor(
    private val weatherApi: WeatherApi
) : CityWeatherDataSource {

    override fun getWeather(cityName: String): Single<CityWeatherModel> =
        weatherApi.getWeatherCity(cityName)


}