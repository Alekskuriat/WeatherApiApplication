package com.example.weatherapiapplication.domain.di

import android.content.Context
import com.example.popularlibraries.domain.schedulers.Schedulers
import com.example.weatherapiapplication.domain.Application
import com.example.weatherapiapplication.domain.api.WeatherApi
import com.example.weatherapiapplication.domain.di.modules.CityWeatherModule
import com.example.weatherapiapplication.domain.di.modules.ListCitiesModule
import com.example.weatherapiapplication.domain.di.modules.StorageModule
import com.example.weatherapiapplication.domain.di.modules.WeatherApiModel
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        WeatherApiModel::class,
        StorageModule::class,
        CityWeatherModule::class,
        ListCitiesModule::class
    ]
)
interface ApplicationComponent : AndroidInjector<Application> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun withContext(context: Context): Builder

        @BindsInstance
        fun withRouter(router: Router): Builder

        @BindsInstance
        fun withNavigatorHolder(navigatorHolder: NavigatorHolder): Builder

        @BindsInstance
        fun withSchedulers(schedulers: Schedulers): Builder

        fun build(): ApplicationComponent
    }


}