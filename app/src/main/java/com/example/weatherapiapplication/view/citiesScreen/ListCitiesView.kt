package com.example.weatherapiapplication.view.citiesScreen

import com.example.weatherapiapplication.domain.city.CityModel
import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface ListCitiesView : MvpView {

    fun showCities(list: List<CityModel>)

    fun showError(throwable: Throwable)

    fun showLoading()

}