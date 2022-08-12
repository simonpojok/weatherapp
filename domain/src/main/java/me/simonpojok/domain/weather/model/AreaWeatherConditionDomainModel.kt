package me.simonpojok.domain.weather.model

data class AreaWeatherConditionDomainModel(
    val weather: WeatherDomainModel,
    val main: WeatherBreakDownDomainModel
)
