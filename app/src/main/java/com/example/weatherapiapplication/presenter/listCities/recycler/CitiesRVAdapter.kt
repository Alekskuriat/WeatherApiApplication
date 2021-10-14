package com.example.weatherapiapplication.presenter.listCities.recycler

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapiapplication.R
import com.example.weatherapiapplication.domain.city.CityModel
import io.reactivex.rxjava3.disposables.CompositeDisposable


class CitiesRVAdapter(
    private val delegate: CityClickListener
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
        holder.set(list[position])
        holder.itemView.tag = list[position]
    }


    inner class ViewHolder(item: View) : RecyclerView.ViewHolder(item),
        UserItemView {

        private var cityName: TextView = itemView.findViewById(R.id.city_name)

        override var pos = -1

        override fun set(city: CityModel) {
            cityName.text = city.nameRU.uppercase()

        }

    }
}