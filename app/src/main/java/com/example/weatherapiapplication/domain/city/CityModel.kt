package com.example.weatherapiapplication.domain.city

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.weatherapiapplication.domain.city.CityModel.Companion.TABLE_NAME
import com.example.weatherapiapplication.domain.weatherModel.CityWeatherModel
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity(tableName = TABLE_NAME)
data class CityModel(

    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "name")
    val name: String,

    @ColumnInfo(name = "nameRU")
    val nameRU: String,

    @ColumnInfo(name = "lat")
    val lat: Double,

    @ColumnInfo(name = "lon")
    val lon: Double,

    ) : Parcelable {
    companion object {
        const val TABLE_NAME = "cities_table"
    }
}


