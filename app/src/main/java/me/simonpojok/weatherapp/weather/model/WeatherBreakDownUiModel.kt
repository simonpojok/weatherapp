package me.simonpojok.weatherapp.weather.model

sealed class WeatherBreakDownUiModel {
    object Empty: WeatherBreakDownUiModel()
    data class Result(
        val currentTemperature: String,
        val minTemperature: String,
        val maxTemperature: String
    ): WeatherBreakDownUiModel()
}
