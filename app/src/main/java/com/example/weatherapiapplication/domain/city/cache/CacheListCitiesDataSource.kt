package com.example.weatherapiapplication.domain.city.cache

import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.city.data.ListCitiesDataSource
import io.reactivex.rxjava3.core.Single

interface CacheListCitiesDataSource : ListCitiesDataSource {

    fun retain(listCities: List<CityModel>) : Single<List<CityModel>>

}