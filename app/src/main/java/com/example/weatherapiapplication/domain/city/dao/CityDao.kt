package com.example.weatherapiapplication.domain.city.dao

import androidx.room.*
import com.example.weatherapiapplication.domain.city.CityModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single


@Dao
interface CityDao {

    @Query("SELECT * FROM ${CityModel.TABLE_NAME}")
    fun getCities(): Single<List<CityModel>>

    @Query("SELECT * FROM ${CityModel.TABLE_NAME} WHERE :name LIKE name LIMIT 1")
    fun getCity(name: String): Single<CityModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addListCities(cities: List<CityModel>): Completable

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addCity(city: CityModel): Completable

    @Delete(entity = CityModel::class)
    fun deleteCity(city: CityModel): Completable



}