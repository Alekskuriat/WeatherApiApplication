package com.example.weatherapiapplication.presenter.listCities

import com.example.popularlibraries.domain.schedulers.Schedulers
import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.city.repo.ListCitiesRepo
import com.example.weatherapiapplication.view.citiesScreen.ListCitiesView
import com.github.terrakok.cicerone.Router
import io.reactivex.rxjava3.disposables.CompositeDisposable
import moxy.MvpPresenter
import javax.inject.Inject

class ListCitiesPresenter
@Inject constructor(
    private val repo: ListCitiesRepo,
    private val router: Router,
    private val schedulers: Schedulers
) : MvpPresenter<ListCitiesView>() {

    private val disposable = CompositeDisposable()

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()

        viewState.showLoading()

        disposable.add(
            repo
                .getCities()
                .observeOn(schedulers.main())
                .subscribeOn(schedulers.background())
                .subscribe(
                    viewState::showCities,
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