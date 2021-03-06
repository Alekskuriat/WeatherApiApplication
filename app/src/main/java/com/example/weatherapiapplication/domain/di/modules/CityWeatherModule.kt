package com.example.weatherapiapplication.domain.di.modules

import com.example.weatherapiapplication.domain.weatherModel.cache.CacheCityWeatherDataSource
import com.example.weatherapiapplication.domain.weatherModel.cache.CacheCityWeatherDataSourceImpl
import com.example.weatherapiapplication.domain.weatherModel.data.CityWeatherDataSource
import com.example.weatherapiapplication.domain.weatherModel.data.CityWeatherDataSourceImpl
import com.example.weatherapiapplication.domain.weatherModel.repo.CityWeatherRepo
import com.example.weatherapiapplication.domain.weatherModel.repo.CityWeatherRepoImpl
import com.example.weatherapiapplication.view.citiesScreen.CitiesFragment
import com.example.weatherapiapplication.view.listCities.ListCitiesFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface CityWeatherModule {

    @ContributesAndroidInjector
    fun bindCitiesFragment(): CitiesFragment

    @Binds
    fun bindCityWeatherRepo(
        cityWeatherRepoImpl: CityWeatherRepoImpl
    ): CityWeatherRepo

    @Binds
    fun bindCityWeatherDataSource(
        cityWeatherDataSourceImpl: CityWeatherDataSourceImpl
    ): CityWeatherDataSource

    @Binds
    fun bindCacheCityWeatherDataSource(
        cityCacheWeatherDataSourceImpl: CacheCityWeatherDataSourceImpl
    ): CacheCityWeatherDataSource
}