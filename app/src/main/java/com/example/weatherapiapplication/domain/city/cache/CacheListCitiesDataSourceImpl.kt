package com.example.weatherapiapplication.domain.city.cache

import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.storage.WeatherStorage
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CacheListCitiesDataSourceImpl
@Inject constructor(
    private val weatherStorage: WeatherStorage
) : CacheListCitiesDataSource {


    override fun retain(listCities: List<CityModel>): Single<List<CityModel>> =
        weatherStorage
            .getCityDao()
            .retain(listCities)
            .andThen(getCities())


    override fun getCities(): Single<List<CityModel>> =
        weatherStorage
            .getCityDao()
            .getCities()

}