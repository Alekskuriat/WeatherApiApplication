package com.example.weatherapiapplication.domain.di.modules

import com.example.weatherapiapplication.MainActivity
import com.example.weatherapiapplication.domain.city.ListCities
import com.example.weatherapiapplication.domain.city.ListCitiesMock
import com.example.weatherapiapplication.domain.city.cache.CacheListCitiesDataSource
import com.example.weatherapiapplication.domain.city.cache.CacheListCitiesDataSourceImpl
import com.example.weatherapiapplication.domain.city.data.ListCitiesDataSource
import com.example.weatherapiapplication.domain.city.data.ListCitiesDataSourceImpl
import com.example.weatherapiapplication.domain.city.repo.ListCitiesRepo
import com.example.weatherapiapplication.domain.city.repo.ListCitiesRepoImpl
import com.example.weatherapiapplication.domain.weatherModel.cache.CacheCityWeatherDataSource
import com.example.weatherapiapplication.domain.weatherModel.cache.CacheCityWeatherDataSourceImpl
import com.example.weatherapiapplication.domain.weatherModel.data.CityWeatherDataSource
import com.example.weatherapiapplication.domain.weatherModel.data.CityWeatherDataSourceImpl
import com.example.weatherapiapplication.domain.weatherModel.repo.CityWeatherRepoImpl
import com.example.weatherapiapplication.view.citiesScreen.ListCitiesFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ListCitiesModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindListCitiesFragment(): ListCitiesFragment

    @Binds
    fun bindListCityRepo(
        listCitiesRepoImpl: ListCitiesRepoImpl
    ): ListCitiesRepo

    @Binds
    fun bindListCitiesDataSource(
        listCitiesDataSourceImpl: ListCitiesDataSourceImpl
    ): ListCitiesDataSource

    @Binds
    fun bindCacheListCitiesDataSource(
        cacheListCitiesDataSourceImpl: CacheListCitiesDataSourceImpl
    ): CacheListCitiesDataSource

    @Binds
    fun bindListCities(
        listCitiesMock: ListCitiesMock
    ): ListCities
}