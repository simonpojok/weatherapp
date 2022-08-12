package me.simonpojok.domain.weather.model

data class AreaWeatherConditionDomainModel(
    val weather: List<WeatherDomainModel>,
    val main: WeatherBreakDownDomainModel
)
