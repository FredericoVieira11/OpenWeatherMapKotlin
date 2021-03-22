package com.example.openweathermapkotlin.network.repository

import com.example.openweathermapkotlin.network.response.CityWeatherResponse
import retrofit2.Response

interface ICityWeatherRepository {

    suspend fun getCityWeatherDescription(
            name: String
    ): Response<CityWeatherResponse>
}