package com.example.weatherapiapplication.presenter.listCities

import com.example.popularlibraries.domain.schedulers.Schedulers
import com.example.weatherapiapplication.domain.api.WeatherApi
import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.city.repo.ListCitiesRepo
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import com.example.weatherapiapplication.domain.weatherModel.repo.CityWeatherRepo
import com.example.weatherapiapplication.presenter.citiesScreen.CitiesWeatherScreen
import com.example.weatherapiapplication.view.listCities.ListCitiesView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import javax.inject.Inject

class ListCitiesPresenter
@Inject constructor(
    private val repoWeather: CityWeatherRepo,
    private val repo: ListCitiesRepo,
    private val router: Router,
    private val schedulers: Schedulers
) : MvpPresenter<ListCitiesView>() {

    private val disposable = CompositeDisposable()
    private var map = mutableMapOf<CityModel, CityWeatherModel?>()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showLoading()

        disposable.add(
            repo
                .getCities()
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    {
                        viewState.showCities(it, map)
                        getWeatherCity(it)
                    },
                    {
                        viewState.showError(it)
                    }
                )
        )
    }

    private fun getWeatherCity(list: List<CityModel>) {

        for (i in list.indices) {
            repoWeather
                .getWeatherCity(list[i].name)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    {
                        viewState.showWeatherCity(it, i)
                        map[list[i]] = it
                    },
                    {
                        viewState.showError(it)
                    }
                )
        }
    }

    fun openWeatherCity(city: CityModel) {
        router.navigateTo(CitiesWeatherScreen().cityWeather(city))
    }


    fun backPressed(): Boolean {
        router.exit()
        return true
    }

    override fun onDestroy() {
        disposable.dispose()
        super.onDestroy()
    }
}