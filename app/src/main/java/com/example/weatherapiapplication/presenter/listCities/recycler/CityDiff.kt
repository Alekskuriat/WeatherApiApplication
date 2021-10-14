package com.example.weatherapiapplication.presenter.listCities.recycler

import androidx.recyclerview.widget.DiffUtil
import com.example.weatherapiapplication.domain.city.CityModel

class CityDiff(
    private val oldList: List<CityModel>,
    private val newList: List<CityModel>
) : DiffUtil.Callback() {


    override fun getOldListSize(): Int {
        return oldList.size
    }

    override fun getNewListSize(): Int {
        return newList.size
    }

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].name == newList[newItemPosition].name
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}
