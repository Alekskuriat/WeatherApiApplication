package com.example.weatherapiapplication.presenter.listCities.recycler

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapiapplication.R
import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import com.example.weatherapiapplication.domain.weatherModel.repo.CityWeatherRepo
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers
import java.util.*
import javax.inject.Inject


class CitiesRVAdapter(
    private val delegate: CityClickListener,
    private val repo: CityWeatherRepo,
    private val schedulers: com.example.popularlibraries.domain.schedulers.Schedulers
) : RecyclerView.Adapter<CitiesRVAdapter.ViewHolder>() {

    private val list: MutableList<CityModel> = mutableListOf()


    fun submit(users: List<CityModel>) {
        val callback = CityDiff(
            oldList = list,
            newList = users
        )
        val result = DiffUtil.calculateDiff(callback)
        list.clear()
        list.addAll(users)
        result.dispatchUpdatesTo(this)
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
        repo
            .getWeatherCity(list[position].name)
            .observeOn(schedulers.main())
            .subscribeOn(schedulers.background())
            .subscribe(
                {
                    holder.set(list[position], it)
                    holder.itemView.tag = list[position]
                },
                {
                    holder.setWithoutWeather(list[position])
                    holder.itemView.tag = list[position]

                }
            )

    }


    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item),
        UserItemView {

        private var cityName: TextView = itemView.findViewById(R.id.city_name)
        private var cityTemp: TextView = itemView.findViewById(R.id.city_temp)

        override var pos = -1

        override fun set(city: CityModel, weather: CityWeatherModel) {
            cityName.text = city.nameRU.uppercase()
            cityTemp.text = weather.weatherMain.temp.toString()

        }

        override fun setWithoutWeather(city: CityModel) {
            cityName.text = city.nameRU.uppercase()
        }

    }
}