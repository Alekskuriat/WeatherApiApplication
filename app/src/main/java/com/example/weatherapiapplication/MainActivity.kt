package com.example.weatherapiapplication


import android.os.Bundle
import com.example.popularlibraries.domain.abs.AbsActivity
import com.example.weatherapiapplication.domain.weatherModel.repo.CityWeatherRepo
import com.example.weatherapiapplication.presenter.listCities.ListCitiesScreen
import com.github.terrakok.cicerone.androidx.AppNavigator
import javax.inject.Inject

class MainActivity : AbsActivity(R.layout.activity_main) {

    private val navigator = AppNavigator(this, R.id.container)

    @Inject
    lateinit var repo: CityWeatherRepo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        savedInstanceState ?: router.newRootScreen(ListCitiesScreen().cities())
    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigatorHolder.removeNavigator()
    }

}