package com.example.weatherapiapplication.domain.weatherModel.cache

import com.example.weatherapiapplication.domain.storage.RoomStorage
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherEntity
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CacheCityWeatherDataSourceImpl
@Inject constructor(
    private val weatherStorage: RoomStorage
) : CacheCityWeatherDataSource {

    override fun saveWeatherCity(cityName: String, weather: CityWeatherModel): Completable =
        weatherStorage
            .getCityWeatherDao()
            .addWeatherCity(
                CityWeatherEntity(
                    city = cityName,
                    temp = weather.weatherMain.temp,
                    feelLike = weather.weatherMain.feelLike,
                    tempMin = weather.weatherMain.tempMin,
                    tempMax = weather.weatherMain.tempMax,
                    pressure = weather.weatherMain.pressure,
                    humidity = weather.weatherMain.humidity,
                    windSpeed = weather.wind.windSpeed,
                    windDeg = weather.wind.windDeg,
                    cloudPercent = weather.clouds.cloudPercent
                )
            )


    override fun getWeather(cityName: String): Single<CityWeatherEntity> =
        weatherStorage
            .getCityWeatherDao()
            .getWeatherCity(cityName)


}