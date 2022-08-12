package me.simonpojok.presentation.weather.model

sealed class WeatherPresentationModel {
    object Empty : WeatherPresentationModel()
    data class Result(
        val id: Int,
        val main: String,
        val description: String,
        val icon: String,
        val temperature: Double
    ) : WeatherPresentationModel()
}
