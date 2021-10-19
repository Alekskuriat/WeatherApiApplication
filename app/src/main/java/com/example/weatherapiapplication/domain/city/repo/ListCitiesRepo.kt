package com.example.weatherapiapplication.domain.city.repo

import com.example.weatherapiapplication.domain.city.CityModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single

interface ListCitiesRepo {

    fun getCities(): Observable<List<CityModel>>
}