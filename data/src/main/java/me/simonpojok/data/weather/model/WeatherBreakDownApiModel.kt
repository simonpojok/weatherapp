package me.simonpojok.data.weather.model

data class WeatherBreakDownApiModel(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Double,
    val humidity: Double
)
