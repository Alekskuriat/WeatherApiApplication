package com.example.weatherapiapplication.domain.city.cache

import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.storage.RoomStorage
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CacheListCitiesDataSourceImpl
@Inject constructor(
    private val weatherStorage: RoomStorage
) : CacheListCitiesDataSource {


    override fun saveListCities(listCities: List<CityModel>): Completable =
        weatherStorage
            .getCityDao()
            .addListCities(listCities)


    override fun getCities(): Single<List<CityModel>> =
        weatherStorage
            .getCityDao()
            .getCities()

}