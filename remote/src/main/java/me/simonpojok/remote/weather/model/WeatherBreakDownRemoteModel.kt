package me.simonpojok.remote.weather.model

data class WeatherBreakDownRemoteModel(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Double,
    val humidity: Double
)
