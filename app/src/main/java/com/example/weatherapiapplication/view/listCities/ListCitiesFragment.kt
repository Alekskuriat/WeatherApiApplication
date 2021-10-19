package com.example.weatherapiapplication.view.listCities

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.popularlibraries.domain.abs.AbsFragment
import com.example.weatherapiapplication.R
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weatherapiapplication.databinding.ListCitiesFragmentBinding
import com.example.weatherapiapplication.domain.api.WeatherApi
import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.city.repo.ListCitiesRepo
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import com.example.weatherapiapplication.domain.weatherModel.repo.CityWeatherRepo
import com.example.weatherapiapplication.presenter.listCities.ListCitiesPresenter
import com.example.weatherapiapplication.presenter.listCities.recycler.CitiesRVAdapter
import com.example.weatherapiapplication.presenter.listCities.recycler.CityClickListener
import com.example.weatherapiapplication.view.BackButtonListener
import moxy.ktx.moxyPresenter
import javax.inject.Inject

class ListCitiesFragment
    : AbsFragment(R.layout.list_cities_fragment),
    ListCitiesView,
    BackButtonListener,
    CityClickListener {



    @Inject
    lateinit var weatherRepo: CityWeatherRepo

    @Inject
    lateinit var repo: ListCitiesRepo

    @Inject
    lateinit var repoWeather: CityWeatherRepo

    private val viewBinding: ListCitiesFragmentBinding by viewBinding()

    private val presenter: ListCitiesPresenter by moxyPresenter {
        ListCitiesPresenter(
            weatherRepo,
            repo,
            router,
            schedulers
        )
    }

    companion object {
        fun newInstance() = ListCitiesFragment()
    }

    var adapter: CitiesRVAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.also {
            it.rvCities.let { rv ->
                rv.layoutManager = LinearLayoutManager(context)
                adapter = CitiesRVAdapter(this)
                rv.adapter = adapter
            }

        }

    }


    override fun onClickCity(city: CityModel) {
        presenter.openWeatherCity(city)
    }

    override fun backPressed(): Boolean = presenter.backPressed()

    override fun showCities(list: List<CityModel>, map: MutableMap<CityModel, CityWeatherModel?>) {
        viewBinding.progress.visibility = View.GONE
        adapter?.submit(list, map)
            ?: Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun showError(throwable: Throwable) {
        viewBinding.progress.visibility = View.GONE
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        viewBinding.progress.visibility = View.VISIBLE
    }

    override fun showWeatherCity(weather: CityWeatherModel, position: Int) {
        adapter?.updateItemWeather(position, weather)
        adapter?.notifyItemChanged(position)
    }


}