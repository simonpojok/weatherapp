package me.simonpojok.data.weather.model

import me.simonpojok.domain.weather.model.CoordinateDomainModel
import me.simonpojok.domain.weather.model.SystemDomainModel
import me.simonpojok.domain.weather.model.WeatherBreakDownDomainModel
import me.simonpojok.domain.weather.model.WeatherDomainModel
import me.simonpojok.domain.weather.model.WindDomainModel

data class AreaWeatherConditionDataModel(
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
