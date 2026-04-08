package com.example.mod7apirest

data class WeatherResponse(
    val hourly : HourlyData
)
data class HourlyData(
    val time : List<String>,
    val temperature_2m : List<Double>
)

