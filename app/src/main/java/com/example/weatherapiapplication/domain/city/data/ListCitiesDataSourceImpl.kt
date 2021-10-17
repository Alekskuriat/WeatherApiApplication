package com.example.weatherapiapplication.domain.city.data

import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.api.CitiesApiMock
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class ListCitiesDataSourceImpl
@Inject constructor(
    private val listCities: CitiesApiMock
) : ListCitiesDataSource {

    override fun getCities(): Single<List<CityModel>> =
        listCities.getCities()

}

