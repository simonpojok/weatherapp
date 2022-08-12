package me.simonpojok.presentation.weather.model

data class AreaWeatherConditionPresentationModel(
    val timestamp: Long,
    val weatherBreakDown: WeatherBreakDownPresentationModel,
    val weather: WeatherPresentationModel
)
