package com.example.weatherapiapplication.domain.city

import io.reactivex.rxjava3.core.Single
import java.util.*

interface ListCities {

    fun getCities() : Single<List<CityModel>>
}