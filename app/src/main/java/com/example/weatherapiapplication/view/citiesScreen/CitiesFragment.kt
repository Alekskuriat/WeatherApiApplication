package com.example.weatherapiapplication.view.citiesScreen

import android.annotation.SuppressLint
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
import com.example.weatherapiapplication.domain.weatherModel.WindDeg
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

    @SuppressLint("SetTextI18n")
    override fun showWeather(weather: CityWeatherModel) {
        viewBinding.progress.visibility = View.GONE
        viewBinding.apply {
            cityName.text = city.nameRU

            cityTemp.text =
                "Температура: ${DecimalFormat("##.0").format(weather.weatherMain.temp - KELVIN)} C"
            cityTempMax.text =
                "Температура max: ${DecimalFormat("##.0").format(weather.weatherMain.tempMax - KELVIN)} C"
            cityTempMin.text =
                "Температура min: ${DecimalFormat("##.0").format(weather.weatherMain.tempMin - KELVIN)} C"
            cityFeelsLike.text =
                "Ощущается: ${DecimalFormat("##.0").format(weather.weatherMain.feelLike - KELVIN)} C"

            cityCloudPercent.text =
                "Облачность: ${weather.clouds.cloudPercent}"
            cityHumidity.text =
                "Влажность: ${weather.weatherMain.humidity}%"

            cityPressure.text =
                "Давление: ${weather.weatherMain.pressure} мПа"

            cityWindSpeed.text =
                "Скорость ветра: ${weather.wind.windSpeed} м/с"
            cityWindDeg.text =
                "Направление ветра: ${determineDirectionWind(weather.wind.windDeg).dir}"

        }
    }

    override fun showError(throwable: Throwable) {
        viewBinding.progress.visibility = View.GONE
        Toast.makeText(context, getString(R.string.error), Toast.LENGTH_LONG).show()
    }

    override fun showLoading() {
        viewBinding.progress.visibility = View.VISIBLE
    }

    private fun determineDirectionWind(deg: Int): WindDeg {
        for (direction in WindDeg.values()) {
            if (deg >= direction.deg) return direction
        }
        return WindDeg.N
    }

}


















