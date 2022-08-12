package me.simonpojok.remote.weather.mapper

import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import me.simonpojok.remote.common.mapper.RemoteToDataMapper
import me.simonpojok.remote.weather.model.AreaWeatherConditionRemoteModel

class AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper(
    private val coordinateRemoteMapper: CoordinateRemoteModelToCoordinateDataMapper,
    private val weatherRemoteMapper: WeatherRemoteModelToWeatherDataModelMapper,
    private val weatherBreakDataMapper: WeatherBreakDownRemoteModelToWeatherBreakDownDataMapper,
    private val cloudsRemoteMapper: CloudsRemoteModelToCloudsDataModelMapper,
    private val systemRemoteMapper: SystemRemoteModelToSystemDataModelMapper,
    private val windRemoteMapper: WindRemoteModelToWindDataModelMapper
) : RemoteToDataMapper<AreaWeatherConditionRemoteModel, AreaWeatherConditionDataModel>() {
    override fun map(input: AreaWeatherConditionRemoteModel) = AreaWeatherConditionDataModel(
        coord = coordinateRemoteMapper.toData(input.coord),
        weather = weatherRemoteMapper.toData(input.weather),
        base = input.base,
        main = weatherBreakDataMapper.toData(input.main),
        clouds = cloudsRemoteMapper.toData(input.clouds),
        dt = input.dt,
        sys = systemRemoteMapper.toData(input.sys),
        timezone = input.timezone,
        id = input.id,
        name = input.name,
        cod = input.cod,
        visibility = input.visibility,
        wind = windRemoteMapper.toData(input.wind)
    )
}
