package com.example.weatherapiapplication.presenter.citiesScreen

import com.example.popularlibraries.domain.schedulers.Schedulers
import com.example.weatherapiapplication.domain.api.WeatherApi
import com.example.weatherapiapplication.domain.city.repo.ListCitiesRepo
import com.example.weatherapiapplication.domain.weatherModel.repo.CityWeatherRepo
import com.example.weatherapiapplication.view.citiesScreen.CitiesView
import com.example.weatherapiapplication.view.listCities.ListCitiesView
import com.github.terrakok.cicerone.Router
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import javax.inject.Inject

class CitiesWeatherPresenter
@AssistedInject constructor(
    @Assisted private val cityName: String,
    private val repo: CityWeatherRepo,
    private val router: Router,
    private val schedulers: Schedulers
) : MvpPresenter<CitiesView>() {

    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showLoading()

        disposable.add(
            repo
                .getWeatherCity(cityName)
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showWeather,
                    viewState::showError
                )
        )

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