package me.simonpojok.remote.source

import me.simonpojok.authentication.AuthenticationKeyProvider
import me.simonpojok.data.weather.datasource.RemoteWeatherDataSource
import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import me.simonpojok.data.weather.model.CoordinateDataModel
import me.simonpojok.remote.service.OpenWeatherService
import me.simonpojok.remote.weather.mapper.AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper
import me.simonpojok.remote.weather.model.AreaWeatherConditionRemoteModel

class WeatherInformationRemoteSource(
    private val openWeatherService: OpenWeatherService,
    private val authenticationKeyProvider: AuthenticationKeyProvider,
    private val areaWeatherConditionMapper: AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper
) : RemoteWeatherDataSource {
    override suspend fun getAreaWeatherInformation(coord: CoordinateDataModel): AreaWeatherConditionDataModel {
        val query = mapOf(
            "lat" to coord.lat.toString(),
            "lon" to coord.lon.toString(),
            "apiKey" to authenticationKeyProvider.getAuthenticationKey().apiKey
        )
        return openWeatherService.getCurrentWeatherData(query).toData()
    }

    private fun AreaWeatherConditionRemoteModel.toData() = areaWeatherConditionMapper.toData(this)
}
