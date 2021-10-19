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
                CityModel(id = 3, name = "Omsk",nameRU = "Омск", lat = 55.0, lon = 73.400002),
                CityModel(id = 4, name = "Barnaul",nameRU = "Барнаул", lat = 55.0, lon = 73.400002),
                CityModel(id = 5, name = "Vladivostok",nameRU = "Владивосток", lat = 55.0, lon = 73.400002),
                CityModel(id = 6, name = "Samara",nameRU = "Самара", lat = 55.0, lon = 73.400002),
                CityModel(id = 7, name = "Kazan",nameRU = "Казань", lat = 55.0, lon = 73.400002),
                CityModel(id = 8, name = "Krasnodar",nameRU = "Краснодар", lat = 55.0, lon = 73.400002),
                CityModel(id = 9, name = "Pavlodar",nameRU = "Павлодар", lat = 55.0, lon = 73.400002),
                CityModel(id = 10, name = "Vladimir",nameRU = "Владимир", lat = 55.0, lon = 73.400002),
                CityModel(id = 11, name = "Biysk",nameRU = "Бийск", lat = 55.0, lon = 73.400002),
                CityModel(id = 12, name = "Smolensk",nameRU = "Смоленск", lat = 55.0, lon = 73.400002)
            )
        )


}