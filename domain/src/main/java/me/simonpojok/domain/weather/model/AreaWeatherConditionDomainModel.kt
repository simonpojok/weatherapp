package me.simonpojok.domain.weather.model

import me.simonpojok.data.weather.model.CloudsDomainModel

data class AreaWeatherConditionDomainModel(
    val coord: CoordinateDomainModel,
    val weather: WeatherDomainModel,
    val base: String,
    val main: WeatherBreakDownDomainModel,
    val visibility: Long,
    val wind: WindDomainModel,
    val clouds: CloudsDomainModel,
    val dt: Long,
    val sys: SystemDomainModel,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Int
)
