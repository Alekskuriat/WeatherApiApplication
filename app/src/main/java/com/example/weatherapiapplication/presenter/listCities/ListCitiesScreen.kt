package com.example.weatherapiapplication.presenter.listCities

import com.example.weatherapiapplication.view.listCities.ListCitiesFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class ListCitiesScreen {
    fun cities() = FragmentScreen { ListCitiesFragment.newInstance() }
}