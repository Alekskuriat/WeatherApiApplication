package com.example.weatherapiapplication.domain.city.data

import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import io.reactivex.rxjava3.core.Single

interface ListCitiesDataSource {

    fun getCities(): Single<List<CityModel>>
}