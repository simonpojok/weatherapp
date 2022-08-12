package me.simonpojok.remote.weather.mapper

import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import me.simonpojok.remote.common.mapper.RemoteToDataMapper
import me.simonpojok.remote.weather.model.AreaWeatherConditionRemoteModel

class AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper(
    private val weatherRemoteMapper: WeatherRemoteModelToWeatherDataModelMapper,
    private val weatherBreakDataMapper: WeatherBreakDownRemoteModelToWeatherBreakDownDataMapper,
) : RemoteToDataMapper<AreaWeatherConditionRemoteModel, AreaWeatherConditionDataModel>() {
    override fun map(input: AreaWeatherConditionRemoteModel) = AreaWeatherConditionDataModel(
        weather = input.weather.map(weatherRemoteMapper::toData),
        main = weatherBreakDataMapper.toData(input.main)
    )
}
