package com.example.weatherapiapplication.view.citiesScreen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.popularlibraries.domain.abs.AbsFragment
import com.example.weatherapiapplication.R
import com.example.weatherapiapplication.databinding.CitiesWeatherFragmentBinding
import com.example.weatherapiapplication.domain.api.WeatherApi
import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import com.example.weatherapiapplication.domain.weatherModel.repo.CityWeatherRepo
import com.example.weatherapiapplication.presenter.citiesScreen.CitiesWeatherPresenter
import com.example.weatherapiapplication.presenter.citiesScreen.CitiesWeatherPresenterFactory
import com.example.weatherapiapplication.view.BackButtonListener
import moxy.ktx.moxyPresenter
import java.text.DecimalFormat
import javax.inject.Inject

class CitiesFragment :
    AbsFragment(R.layout.cities_weather_fragment),
    CitiesView,
    BackButtonListener {

    private lateinit var city: CityModel

    private val KELVIN = 273.15

    @Inject
    lateinit var weatherApi: WeatherApi

    @Inject
    lateinit var repo: CityWeatherRepo

    @Inject
    lateinit var citiesWeatherPresenterFactory: CitiesWeatherPresenterFactory

    private val viewBinding: CitiesWeatherFragmentBinding by viewBinding()

    companion object {
        const val KEY = "city"
        fun newInstance(city: CityModel): Fragment =
            CitiesFragment().apply {
                arguments = Bundle().apply { putParcelable(KEY, city) }
            }


    }

    override fun onCreate(savedInstanceState: Bundle?) {
        arguments?.let {
            city = it.getParcelable(KEY)!!
        }
        super.onCreate(savedInstanceState)
    }

    private val presenter: CitiesWeatherPresenter by moxyPresenter {
        citiesWeatherPresenterFactory.create(city.name)
    }

    override fun backPressed(): Boolean = presenter.backPressed()

    override fun showWeather(weather: CityWeatherModel) {
        viewBinding.progress.visibility = View.GONE
        viewBinding.apply {
            cityTemp.text =
                DecimalFormat("##.0").format(weather.weatherMain.temp - KELVIN).toString()
            cityName.text = city.nameRU
        }
    }

    override fun showError(throwable: Throwable) {
        viewBinding.progress.visibility = View.GONE
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        viewBinding.progress.visibility = View.VISIBLE
    }


}

private fun CitiesFragment.arguments(array: Array<String>): Fragment {
    this.arguments = bundleOf()
    return this
}

