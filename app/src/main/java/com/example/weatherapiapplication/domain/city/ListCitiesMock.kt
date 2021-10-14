package com.example.weatherapiapplication.domain.city

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ListCitiesMock
    @Inject constructor(

    ): ListCities {

    override fun getCities(): Single<List<CityModel>> =
        Single.just(
            listOf(
                CityModel(id = 1, name = "Moscow",nameRU = "Москва", lat = 55.761665, lon = 37.606667),
                CityModel(id = 2, name = "Novosibirsk",nameRU = "Новосибирск", lat = 55.041111, lon = 82.934441),
                CityModel(id = 1, name = "Omsk",nameRU = "Омск", lat = 55.0, lon = 73.400002)
            )
        )


}