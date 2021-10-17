package com.example.weatherapiapplication.presenter.citiesScreen

import dagger.assisted.AssistedFactory

@AssistedFactory
interface CitiesWeatherPresenterFactory {
    fun create(cityName: String): CitiesWeatherPresenter
}