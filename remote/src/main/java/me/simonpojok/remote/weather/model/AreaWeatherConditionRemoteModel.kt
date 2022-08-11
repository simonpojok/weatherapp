package me.simonpojok.remote.weather.model

data class AreaWeatherConditionRemoteModel(
    val coord: CoordinateRemoteModel,
    val weather: WeatherRemoteModel,
    val base: String,
    val main: WeatherBreakDownRemoteModel,
    val visibility: Long,
    val wind: WindRemoteModel,
    val clouds: CloudsRemoteModel,
    val dt: Long,
    val sys: SystemRemoteModel,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Int
)
