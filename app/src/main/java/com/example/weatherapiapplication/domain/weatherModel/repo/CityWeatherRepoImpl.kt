package com.example.weatherapiapplication.domain.weatherModel.repo

import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import com.example.weatherapiapplication.domain.weatherModel.Cloud
import com.example.weatherapiapplication.domain.weatherModel.WeatherMain
import com.example.weatherapiapplication.domain.weatherModel.Wind
import com.example.weatherapiapplication.domain.weatherModel.cache.CacheCityWeatherDataSource
import com.example.weatherapiapplication.domain.weatherModel.data.CityWeatherDataSource
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class CityWeatherRepoImpl
@Inject constructor(
    private val data: CityWeatherDataSource,
    private val cache: CacheCityWeatherDataSource
) : CityWeatherRepo {


    override fun getWeatherCity(cityName: String): Observable<CityWeatherModel> {

        val remote = data.getWeather(cityName)
            .toObservable()
            .flatMap {
                cache.saveWeatherCity(cityName, it)
                    .andThen(Observable.just(it))
            }

        val local = cache.getWeather(cityName)
            .toObservable()
            .flatMap { weather ->
                Observable.just(
                    CityWeatherModel(
                        id = 1,
                        WeatherMain(
                            temp = weather.temp,
                            feelLike = weather.feelLike,
                            tempMin = weather.tempMin,
                            tempMax = weather.tempMax,
                            pressure = weather.pressure,
                            humidity = weather.humidity
                        ),
                        Wind(
                            windSpeed = weather.windSpeed,
                            windDeg = weather.windDeg
                        ),
                        Cloud(
                            cloudPercent = weather.cloudPercent
                        )
                    )
                )
            }

        return Observable.concat(local, remote)
    }


}