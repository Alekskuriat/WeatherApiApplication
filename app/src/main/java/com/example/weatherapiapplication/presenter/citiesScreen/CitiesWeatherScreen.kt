package com.example.weatherapiapplication.presenter.citiesScreen

import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.view.citiesScreen.CitiesFragment
import com.example.weatherapiapplication.view.listCities.ListCitiesFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class CitiesWeatherScreen {
    fun cityWeather(city: CityModel) =
        FragmentScreen { CitiesFragment.newInstance(city) }
}