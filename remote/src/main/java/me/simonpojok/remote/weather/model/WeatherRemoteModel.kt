package me.simonpojok.remote.weather.model

data class WeatherRemoteModel(
    val id: Int,
    val main: String,
    val description: String,
    val icon: String
)
