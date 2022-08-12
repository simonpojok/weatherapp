package me.simonpojok.data.weather.repository

import me.simonpojok.data.weather.datasource.RemoteWeatherDataSource
import me.simonpojok.data.weather.mapper.AreaWeatherConditionDataToAreaWeatherConditionDomainModelMapper
import me.simonpojok.data.weather.mapper.CoordinateDomainToCoordinateRemoteModelMapper
import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import me.simonpojok.domain.weather.model.AreaWeatherConditionDomainModel
import me.simonpojok.domain.weather.model.CoordinateDomainModel
import me.simonpojok.domain.weather.repository.AreaWeatherInformationRepository

class WeatherInformationDataRepository(
    private val remoteWeatherDataSource: RemoteWeatherDataSource,
    private val coordinateRemoteModelMapper: CoordinateDomainToCoordinateRemoteModelMapper,
    private val areaWeatherConditionDomainMapper: AreaWeatherConditionDataToAreaWeatherConditionDomainModelMapper
) : AreaWeatherInformationRepository {
    override suspend fun getAreaWeatherCondition(coordinateDomainModel: CoordinateDomainModel): AreaWeatherConditionDomainModel {
        print("Calling .........................................................")
        return remoteWeatherDataSource.getAreaWeatherInformation(
            coordinateRemoteModelMapper.toData(coordinateDomainModel)
        ).toDomain()
    }

    private fun AreaWeatherConditionDataModel.toDomain() =
        areaWeatherConditionDomainMapper.toDomain(this)
}
