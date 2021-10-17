package com.example.weatherapiapplication.view.citiesScreen

import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.SkipStrategy
import moxy.viewstate.strategy.StateStrategyType
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface CitiesView : MvpView {

    fun showWeather(weather: CityWeatherModel)

    fun showError(throwable: Throwable)

    fun showLoading()

}

