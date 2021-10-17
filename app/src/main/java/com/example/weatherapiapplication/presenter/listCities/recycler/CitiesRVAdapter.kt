package com.example.weatherapiapplication.presenter.listCities.recycler

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapiapplication.R
import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import java.text.DecimalFormat


class CitiesRVAdapter(
    private val delegate: CityClickListener,
) : RecyclerView.Adapter<CitiesRVAdapter.ViewHolder>() {

    private val list: MutableList<CityModel> = mutableListOf()
    private var map: MutableMap<CityModel, CityWeatherModel?> = mutableMapOf()
    private val KELVIN = 273.15

    fun submit(users: List<CityModel>, map: MutableMap<CityModel, CityWeatherModel?>) {
        val callback = CityDiff(
            oldList = list,
            newList = users
        )
        val result = DiffUtil.calculateDiff(callback)
        list.clear()
        list.addAll(users)
        this.map = map
        result.dispatchUpdatesTo(this)
    }

    fun updateItemWeather(position: Int, weather: CityWeatherModel) {
        map[list[position]] = weather
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val rootView: View = LayoutInflater.from(parent.context).inflate(
            R.layout.city_item,
            parent,
            false
        )
        rootView.setOnClickListener {
            delegate.onClickCity(it.tag as CityModel)
        }
        return ViewHolder(rootView)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.set(list[position])
        holder.itemView.tag = list[position]

    }


    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item),
        UserItemView {

        private var cityName: TextView = itemView.findViewById(R.id.city_name)
        private var cityTemp: TextView = itemView.findViewById(R.id.city_temp)
        private var cityWindSpeed: TextView = itemView.findViewById(R.id.city_wind_speed)
        private var progressBar: ProgressBar = itemView.findViewById(R.id.weather_progress)

        override var pos = -1

        @SuppressLint("SetTextI18n")
        override fun set(city: CityModel) {
            cityName.text = city.nameRU.uppercase()
            if (map[city] == null) {
                progressBar.visibility = View.VISIBLE
                cityTemp.visibility = View.GONE
                cityWindSpeed.visibility = View.GONE
            } else {
                progressBar.visibility = View.GONE
                cityTemp.text = "Температура: ${
                    map[city]?.weatherMain?.temp?.let {
                        kelvinToCelsius(
                            it
                        )
                    }
                } С"
                cityWindSpeed.text = "Скорость ветра: ${map[city]?.wind?.windSpeed.toString()} м/с"
                cityTemp.visibility = View.VISIBLE
                cityWindSpeed.visibility = View.VISIBLE
            }


        }

        fun kelvinToCelsius(k: Double): String =
            DecimalFormat("##.0").format(k - KELVIN).toString()


    }
}