package me.simonpojok.data.weather.model

data class AreaWeatherConditionDataModel(
    val weather: List<WeatherDataModel>,
    val main: WeatherBreakDownDataModel,
    val timestamp: Long,
    val dateTime: String
)
