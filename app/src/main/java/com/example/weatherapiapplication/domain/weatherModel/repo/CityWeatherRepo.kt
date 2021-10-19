package com.example.weatherapiapplication.domain.weatherModel.repo

import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import io.reactivex.rxjava3.core.Observable

interface CityWeatherRepo {

    fun getWeatherCity(cityName: String) : Observable<CityWeatherModel>


}