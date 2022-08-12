package me.simonpojok.remote.source

import me.simonpojok.authentication.AuthenticationKeyProvider
import me.simonpojok.data.weather.datasource.RemoteWeatherDataSource
import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import me.simonpojok.data.weather.model.CoordinateDataModel
import me.simonpojok.remote.service.OpenWeatherService
import me.simonpojok.remote.weather.mapper.AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper
import me.simonpojok.remote.weather.model.AreaWeatherConditionRemoteModel
import me.simonpojok.remote.weather.model.AreaWeatherForecastRemoteModel

class WeatherInformationRemoteSource(
    private val openWeatherService: OpenWeatherService,
    private val authenticationKeyProvider: AuthenticationKeyProvider,
    private val areaWeatherConditionMapper: AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper
) : RemoteWeatherDataSource {
    override suspend fun getAreaWeatherInformation(coord: CoordinateDataModel): AreaWeatherConditionDataModel {
        return openWeatherService.getCurrentWeatherData(coord.toQueryMap()).toData()
    }

    override suspend fun getWeeklyAreaWeatherForcasts(coord: CoordinateDataModel): List<AreaWeatherConditionDataModel> {
        return openWeatherService.getCurrentWeatherForecastData(coord.toQueryMap()).toData()
    }

    private fun AreaWeatherConditionRemoteModel.toData() = areaWeatherConditionMapper.toData(this)

    private fun AreaWeatherForecastRemoteModel.toData() =
        this.list.map(areaWeatherConditionMapper::toData)

    private fun CoordinateDataModel.toQueryMap() = mapOf(
        "lat" to this.lat.toString(),
        "lon" to this.lon.toString(),
        "apiKey" to authenticationKeyProvider.getAuthenticationKey().apiKey
    )
}
