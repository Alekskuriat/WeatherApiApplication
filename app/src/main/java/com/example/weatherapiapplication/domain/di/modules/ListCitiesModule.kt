package com.example.weatherapiapplication.domain.di.modules

import com.example.weatherapiapplication.MainActivity
import com.example.weatherapiapplication.domain.api.CitiesApi
import com.example.weatherapiapplication.domain.api.CitiesApiMock
import com.example.weatherapiapplication.domain.city.cache.CacheListCitiesDataSource
import com.example.weatherapiapplication.domain.city.cache.CacheListCitiesDataSourceImpl
import com.example.weatherapiapplication.domain.city.data.ListCitiesDataSource
import com.example.weatherapiapplication.domain.city.data.ListCitiesDataSourceImpl
import com.example.weatherapiapplication.domain.city.repo.ListCitiesRepo
import com.example.weatherapiapplication.domain.city.repo.ListCitiesRepoImpl
import com.example.weatherapiapplication.view.listCities.ListCitiesFragment
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import javax.inject.Singleton

@Module
interface ListCitiesModule {

    @ContributesAndroidInjector
    fun bindMainActivity(): MainActivity

    @ContributesAndroidInjector
    fun bindListCitiesFragment(): ListCitiesFragment

    @Binds
    @Singleton
    fun bindListCityRepo(
        listCitiesRepoImpl: ListCitiesRepoImpl
    ): ListCitiesRepo

    @Binds
    @Singleton
    fun bindListCitiesDataSource(
        listCitiesDataSourceImpl: ListCitiesDataSourceImpl
    ): ListCitiesDataSource

    @Binds
    @Singleton
    fun bindCacheListCitiesDataSource(
        cacheListCitiesDataSourceImpl: CacheListCitiesDataSourceImpl
    ): CacheListCitiesDataSource

    @Binds
    @Singleton
    fun bindListCities(
        listCitiesMock: CitiesApiMock
    ): CitiesApi
}