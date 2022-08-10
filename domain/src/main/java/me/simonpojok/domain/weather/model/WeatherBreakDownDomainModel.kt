package me.simonpojok.domain.weather.model

data class WeatherBreakDownDomainModel(
    val temp: Double,
    val feels_like: Double,
    val temp_min: Double,
    val temp_max: Double,
    val pressure: Double,
    val humidity: Double
)
