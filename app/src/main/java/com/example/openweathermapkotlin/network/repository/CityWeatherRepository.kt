package com.example.openweathermapkotlin.network.repository

import com.example.openweathermapkotlin.network.ApiService
import com.example.openweathermapkotlin.network.response.CityWeatherResponse
import com.example.openweathermapkotlin.utils.Utils
import retrofit2.Response
import javax.inject.Inject

class CityWeatherRepository @Inject constructor(
        private val apiService: ApiService
): ICityWeatherRepository {
    override suspend fun getCityWeatherDescription(
            name: String
    ): Response<CityWeatherResponse> = apiService.getCityWeatherDescription(q = name, units = Utils.units, appId = Utils.appId)
}