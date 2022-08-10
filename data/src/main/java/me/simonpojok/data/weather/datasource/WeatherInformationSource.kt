package me.simonpojok.data.weather.datasource

import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import me.simonpojok.data.weather.model.CoordinateApiModel
import me.simonpojok.data.weather.model.CoordinateDataModel
import me.simonpojok.domain.weather.model.CoordinateDomainModel

interface WeatherInformationSource {
    suspend fun getAreaWeatherInformation(coordinate: CoordinateApiModel): AreaWeatherConditionDataModel
}
