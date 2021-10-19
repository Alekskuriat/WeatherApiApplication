package com.example.weatherapiapplication.domain.city.cache

import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.city.data.ListCitiesDataSource
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

interface CacheListCitiesDataSource : ListCitiesDataSource {

    fun saveListCities(listCities: List<CityModel>): Completable

}