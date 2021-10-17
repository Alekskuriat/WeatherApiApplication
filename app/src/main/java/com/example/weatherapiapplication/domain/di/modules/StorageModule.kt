package com.example.weatherapiapplication.domain.di.modules

import android.content.Context
import androidx.room.Room
import com.example.weatherapiapplication.domain.storage.WeatherStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideGithubStorage(context: Context): WeatherStorage =
        Room
            .databaseBuilder(
                context,
                WeatherStorage::class.java,
                "weather.db"
            )
            .build()



}