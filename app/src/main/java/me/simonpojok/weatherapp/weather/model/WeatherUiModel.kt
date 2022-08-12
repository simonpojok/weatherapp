package me.simonpojok.weatherapp.weather.model

sealed class WeatherUiModel {
    object Empty : WeatherUiModel()
    data class Result(
        val temperature: String,
        val condition: String
    ): WeatherUiModel()
}
