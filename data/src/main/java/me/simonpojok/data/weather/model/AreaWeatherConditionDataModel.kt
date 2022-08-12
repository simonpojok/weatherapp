package me.simonpojok.data.weather.model

import java.sql.Timestamp

data class AreaWeatherConditionDataModel(
    val weather: List<WeatherDataModel>,
    val main: WeatherBreakDownDataModel,
    val timestamp: Long
)
