package me.simonpojok.data.weather.datasource

import me.simonpojok.authentication.AuthenticationKeyProvider
import me.simonpojok.data.remote.OpenWeatherService
import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import me.simonpojok.data.weather.model.CoordinateApiModel
import me.simonpojok.data.weather.model.CoordinateDataModel

class WeatherInformationDataSource(
    private val openWeatherService: OpenWeatherService,
    private val authenticationKeyProvider: AuthenticationKeyProvider
): WeatherInformationSource {
    override suspend fun getAreaWeatherInformation(coordinate: CoordinateApiModel): AreaWeatherConditionDataModel {
        TODO("Not yet implemented")
    }
}
