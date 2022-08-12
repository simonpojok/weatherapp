package me.simonpojok.remote.weather.model

data class AreaWeatherConditionRemoteModel(
    val weather: List<WeatherRemoteModel>,
    val main: WeatherBreakDownRemoteModel,
    val dt: Long
)
