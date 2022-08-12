package me.simonpojok.domain.weather.model

data class AreaWeatherConditionDomainModel(
    val timestamp: Long,
    val weather: List<WeatherDomainModel>,
    val main: WeatherBreakDownDomainModel,
    val dateTime: String
)
