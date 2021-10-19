package com.example.weatherapiapplication.domain.di.modules

import android.content.Context
import androidx.room.Room
import com.example.weatherapiapplication.domain.storage.RoomStorage
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class StorageModule {

    @Singleton
    @Provides
    fun provideGithubStorage(context: Context): RoomStorage =
        Room
            .databaseBuilder(
                context,
                RoomStorage::class.java,
                "room_weather.db"
            )
            .build()


}