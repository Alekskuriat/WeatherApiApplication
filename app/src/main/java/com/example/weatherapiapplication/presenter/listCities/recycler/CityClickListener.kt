package com.example.weatherapiapplication.presenter.listCities.recycler

import com.example.weatherapiapplication.domain.city.CityModel

interface CityClickListener {
    fun onClickCity(city: CityModel)

}