package me.simonpojok.data.weather.datasource

import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import me.simonpojok.data.weather.model.CoordinateDataModel

interface WeatherInformationSource {
    suspend fun getAreaWeatherInformation(coordinate: CoordinateDataModel): AreaWeatherConditionDataModel
}
