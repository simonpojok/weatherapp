package me.simonpojok.data.weather.repository

import me.simonpojok.data.weather.datasource.RemoteWeatherDataSource
import me.simonpojok.data.weather.mapper.AreaWeatherConditionDataToAreaWeatherConditionDomainModelMapper
import me.simonpojok.data.weather.mapper.CoordinateDomainToCoordinateRemoteModelMapper
import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import me.simonpojok.domain.weather.model.CoordinateDomainModel
import me.simonpojok.domain.weather.repository.AreaWeatherInformationRepository

class WeatherInformationDataRepository(
    private val remoteWeatherDataSource: RemoteWeatherDataSource,
    private val coordinateRemoteModelMapper: CoordinateDomainToCoordinateRemoteModelMapper,
    private val areaWeatherConditionDomainMapper: AreaWeatherConditionDataToAreaWeatherConditionDomainModelMapper
) : AreaWeatherInformationRepository {
    override suspend fun getAreaWeatherCondition(coordinateDomainModel: CoordinateDomainModel) =
        remoteWeatherDataSource.getAreaWeatherInformation(
            coordinateDomainModel.toData()
        ).toDomain()

    override suspend fun getWeeklyAreaWeatherForecast(coordinateDomainModel: CoordinateDomainModel) =
        remoteWeatherDataSource.getWeeklyAreaWeatherForcasts(coordinateDomainModel.toData())
            .map(areaWeatherConditionDomainMapper::toDomain)

    private fun AreaWeatherConditionDataModel.toDomain() =
        areaWeatherConditionDomainMapper.toDomain(this)

    private fun CoordinateDomainModel.toData() = coordinateRemoteModelMapper.toData(this)
}
