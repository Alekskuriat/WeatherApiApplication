package com.example.weatherapiapplication.domain.city.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weatherapiapplication.domain.city.CityModel
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single


@Dao
interface CityDao {

    @Query("SELECT * FROM cities")
    fun getCities(): Single<List<CityModel>>

    @Query("SELECT * FROM cities WHERE name LIKE :name LIMIT 1")
    fun getCity(name: String): Single<CityModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun retain(cities: List<CityModel>): Completable



}