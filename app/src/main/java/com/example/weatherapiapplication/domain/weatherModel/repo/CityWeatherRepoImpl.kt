package com.example.weatherapiapplication.domain.weatherModel.repo

import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import com.example.weatherapiapplication.domain.weatherModel.cache.CacheCityWeatherDataSource
import com.example.weatherapiapplication.domain.weatherModel.data.CityWeatherDataSource
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class CityWeatherRepoImpl
@Inject constructor(
    private val data: CityWeatherDataSource,
    private val cache: CacheCityWeatherDataSource
) : CityWeatherRepo {


    override fun getWeatherCity(cityName: String): Observable<CityWeatherModel> =
        data.getWeather(cityName).toObservable()


}