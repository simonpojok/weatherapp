package me.simonpojok.data.weather.model

import me.simonpojok.domain.weather.model.CoordinateDomainModel
import me.simonpojok.domain.weather.model.SystemDomainModel
import me.simonpojok.domain.weather.model.WeatherBreakDownDomainModel
import me.simonpojok.domain.weather.model.WeatherDomainModel
import me.simonpojok.domain.weather.model.WindDomainModel

data class AreaWeatherConditionDataModel(
    val coord: CoordinateDataModel,
    val weather: WeatherDataModel,
    val base: String,
    val main: WeatherBreakDownDataModel,
    val visibility: Long,
    val wind: WindDataModel,
    val clouds: CloudsDataModel,
    val dt: Long,
    val sys: SystemDataModel,
    val timezone: Long,
    val id: Long,
    val name: String,
    val cod: Int
)
