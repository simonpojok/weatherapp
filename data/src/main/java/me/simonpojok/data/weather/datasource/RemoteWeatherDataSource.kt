package me.simonpojok.data.weather.datasource

import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import me.simonpojok.data.weather.model.CoordinateDataModel

interface RemoteWeatherDataSource {
    suspend fun getAreaWeatherInformation(
        coord: CoordinateDataModel
    ): AreaWeatherConditionDataModel
}
