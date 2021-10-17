package com.example.weatherapiapplication.view.listCities

import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import com.google.android.material.circularreveal.CircularRevealHelper
import moxy.MvpView
import moxy.viewstate.strategy.*
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface ListCitiesView : MvpView {

    fun showCities(list: List<CityModel>, map: MutableMap<CityModel, CityWeatherModel?>)

    fun showError(throwable: Throwable)

    fun showLoading()

    @StateStrategyType(SkipStrategy::class)
    fun showWeatherCity(weather: CityWeatherModel, position: Int)

}