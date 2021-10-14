package com.example.weatherapiapplication.presenter.listCities.recycler

import com.example.weatherapiapplication.domain.city.CityModel

interface ItemView {
    var pos: Int
}

interface UserItemView : ItemView {
    fun set(city : CityModel)

}