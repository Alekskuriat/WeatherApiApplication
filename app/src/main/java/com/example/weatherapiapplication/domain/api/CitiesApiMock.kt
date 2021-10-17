package com.example.weatherapiapplication.domain.api

import com.example.weatherapiapplication.domain.city.CityModel
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class CitiesApiMock
    @Inject constructor(

    ): CitiesApi {

    override fun getCities(): Single<List<CityModel>> =
        Single.just(
            listOf(
                CityModel(id = 1, name = "Moscow",nameRU = "Москва", lat = 55.761665, lon = 37.606667),
                CityModel(id = 2, name = "Novosibirsk",nameRU = "Новосибирск", lat = 55.041111, lon = 82.934441),
                CityModel(id = 1, name = "Omsk",nameRU = "Омск", lat = 55.0, lon = 73.400002),
                CityModel(id = 1, name = "Barnaul",nameRU = "Барнаул", lat = 55.0, lon = 73.400002),
                CityModel(id = 1, name = "Vladivostok",nameRU = "Владивосток", lat = 55.0, lon = 73.400002),
                CityModel(id = 1, name = "Samara",nameRU = "Самара", lat = 55.0, lon = 73.400002),
                CityModel(id = 1, name = "Kazan",nameRU = "Казань", lat = 55.0, lon = 73.400002),
                CityModel(id = 1, name = "Krasnodar",nameRU = "Краснодар", lat = 55.0, lon = 73.400002),
                CityModel(id = 1, name = "Pavlodar",nameRU = "Павлодар", lat = 55.0, lon = 73.400002),
                CityModel(id = 1, name = "Vladimir",nameRU = "Владимир", lat = 55.0, lon = 73.400002),
                CityModel(id = 1, name = "Biysk",nameRU = "Бийск", lat = 55.0, lon = 73.400002),
                CityModel(id = 1, name = "Smolensk",nameRU = "Смоленск", lat = 55.0, lon = 73.400002)
            )
        )


}