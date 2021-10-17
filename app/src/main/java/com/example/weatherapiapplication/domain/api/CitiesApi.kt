package com.example.weatherapiapplication.domain.api

import com.example.weatherapiapplication.domain.city.CityModel
import io.reactivex.rxjava3.core.Single

interface CitiesApi {

    fun getCities() : Single<List<CityModel>>
}