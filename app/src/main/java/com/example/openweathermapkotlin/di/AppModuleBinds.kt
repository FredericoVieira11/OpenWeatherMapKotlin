package com.example.openweathermapkotlin.di

import com.example.openweathermapkotlin.network.repository.CityWeatherRepository
import com.example.openweathermapkotlin.network.repository.ICityWeatherRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class AppModuleBinds {

    @Binds
    abstract fun bindCityWeatherRepository(repository: CityWeatherRepository): ICityWeatherRepository
}