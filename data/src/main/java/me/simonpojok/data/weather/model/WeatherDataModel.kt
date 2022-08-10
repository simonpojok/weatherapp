package me.simonpojok.data.weather.model

data class WeatherDataModel(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)
