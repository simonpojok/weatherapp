package me.simonpojok.domain.weather.model

data class WeatherDomainModel(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)
