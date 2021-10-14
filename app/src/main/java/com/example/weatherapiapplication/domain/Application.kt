package com.example.weatherapiapplication.domain

import com.example.popularlibraries.domain.schedulers.DefaultSchedulers
import com.example.weatherapiapplication.domain.di.DaggerApplicationComponent
import com.github.terrakok.cicerone.Cicerone
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class Application  : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<Application> =
        DaggerApplicationComponent
            .builder()
            .withContext(applicationContext)
            .apply {
                val cicerone = Cicerone.create()

                withNavigatorHolder(cicerone.getNavigatorHolder())
                withRouter(cicerone.router)
                withSchedulers(DefaultSchedulers())
            }
            .build()
}

