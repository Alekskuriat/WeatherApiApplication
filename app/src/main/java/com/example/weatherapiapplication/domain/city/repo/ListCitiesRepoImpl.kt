package com.example.weatherapiapplication.domain.city.repo

import com.example.weatherapiapplication.domain.city.CityModel
import com.example.weatherapiapplication.domain.city.cache.CacheListCitiesDataSource
import com.example.weatherapiapplication.domain.city.data.ListCitiesDataSource
import io.reactivex.rxjava3.core.Observable
import javax.inject.Inject

class ListCitiesRepoImpl
@Inject constructor(
    private val data: ListCitiesDataSource,
    private val cache: CacheListCitiesDataSource
) : ListCitiesRepo {

    override fun getCities(): Observable<List<CityModel>> =
        /*Observable.merge(
            cache
                .getCities()
                .toObservable(),
            data
                .getCities()
                .flatMap {
                    cache.retain(it)
                }
                .toObservable()
*/
            data
                .getCities()
                .toObservable()
}