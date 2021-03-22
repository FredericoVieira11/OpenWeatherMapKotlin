package com.example.openweathermapkotlin.ui.cityWeather.viewModel

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.openweathermapkotlin.network.repository.ICityWeatherRepository
import com.example.openweathermapkotlin.network.resource.Resource
import kotlinx.coroutines.Dispatchers

class CityWeatherViewModel @ViewModelInject constructor(
    private val repository: ICityWeatherRepository
): ViewModel() {

    fun getCityWeather(name: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(data = null))
        try {
            emit(Resource.success(data = repository.getCityWeatherDescription(name = name)))
        } catch (e: Exception) {
            emit(Resource.error(data = null, message = e.message ?: "Error Occured"))
        }
    }

}