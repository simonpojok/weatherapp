package me.simonpojok.remote.source

import me.simonpojok.authentication.AuthenticationKeyProvider
import me.simonpojok.data.weather.datasource.WeatherInformationSource
import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import me.simonpojok.data.weather.model.CoordinateDataModel
import me.simonpojok.remote.service.OpenWeatherService
import me.simonpojok.remote.weather.mapper.AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper
import me.simonpojok.remote.weather.mapper.CoordinateDataModelToCoordinateRemoteMapper
import me.simonpojok.remote.weather.model.AreaWeatherConditionRemoteModel

class WeatherInformationRemoteSource(
    private val openWeatherService: OpenWeatherService,
    private val authenticationKeyProvider: AuthenticationKeyProvider,
    private val areaWeatherConditionMapper: AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper
) : WeatherInformationSource {
    override suspend fun getAreaWeatherInformation(coordinate: CoordinateDataModel): AreaWeatherConditionDataModel {
        return openWeatherService
            .getCurrentWeatherData(
                lat = coordinate.lat,
                log = coordinate.lon,
                apiKey = authenticationKeyProvider.getAuthenticationKey().apiKey
            ).toData()
    }

    private fun AreaWeatherConditionRemoteModel.toData() = areaWeatherConditionMapper.toData(this)
}
