package com.example.weatherapiapplication.domain.weatherModel.cache

import com.example.weatherapiapplication.domain.storage.WeatherStorage
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CacheCityWeatherDataSourceImpl
@Inject constructor(
    private val weatherStorage: WeatherStorage
) : CacheCityWeatherDataSource {

    override fun retain(cityName: String, weather: CityWeatherModel): Single<CityWeatherModel> =
        weatherStorage
            .getCityWeatherDao()
            .retain(weather)
            .andThen(getWeather(cityName))


    override fun getWeather(cityName: String): Single<CityWeatherModel> =
        weatherStorage
            .getCityWeatherDao()
            .getWeatherCity()




}