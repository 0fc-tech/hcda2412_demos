package com.example.mod7apirest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class WeatherViewModel : ViewModel() {
    private val _weather = MutableStateFlow<HourlyData?>(null)
    val weather = _weather.asStateFlow()
    init {
        fetchWeather()
    }
    private fun fetchWeather() {
        viewModelScope.launch(Dispatchers.IO) {
            _weather.value = RetrofitClient.weatherApiService.getWeatherData(
                lat = 48.04,
                long = -1.69,
                current = "temperature_2m,wind_speed_10m",
                hourly = "temperature_2m"
            ).hourly
        }
    }
}
