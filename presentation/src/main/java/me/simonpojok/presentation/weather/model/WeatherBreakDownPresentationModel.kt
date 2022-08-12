package me.simonpojok.presentation.weather.model

sealed class WeatherBreakDownPresentationModel {
    object Empty : WeatherBreakDownPresentationModel()
    data class Result(
        val temp: Double,
        val feels_like: Double,
        val tempMin: Double,
        val tempMax: Double,
        val pressure: Double,
        val humidity: Double
    ) : WeatherBreakDownPresentationModel()
}
