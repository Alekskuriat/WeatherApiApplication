package com.example.weatherapiapplication.presenter.listCities.recycler

import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel

interface ItemView {
    var pos: Int
}

interface UserItemView : ItemView {
    fun set(city : CityModel, weather: CityWeatherModel)

    fun setWithoutWeather(city : CityModel)

}