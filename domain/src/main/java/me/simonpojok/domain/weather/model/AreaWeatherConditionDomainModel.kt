package me.simonpojok.domain.weather.model

import java.sql.Timestamp

data class AreaWeatherConditionDomainModel(
    val timestamp: Long,
    val weather: List<WeatherDomainModel>,
    val main: WeatherBreakDownDomainModel
)
