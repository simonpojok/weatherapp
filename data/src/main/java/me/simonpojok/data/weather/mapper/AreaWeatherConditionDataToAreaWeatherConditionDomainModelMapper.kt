package me.simonpojok.data.weather.mapper

import me.simonpojok.data.common.mapper.DataToDomainMapper
import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import me.simonpojok.domain.weather.model.AreaWeatherConditionDomainModel

class AreaWeatherConditionDataToAreaWeatherConditionDomainModelMapper(
    private val weatherBreakDownDataModelToWeatherBreakDownDomainMapper: WeatherBreakDownDataModelToWeatherBreakDownDomainMapper,
    private val weatherDataModelToWeatherDomainModelMapper: WeatherDataModelToWeatherDomainModelMapper
) : DataToDomainMapper<AreaWeatherConditionDataModel, AreaWeatherConditionDomainModel>() {
    override fun map(input: AreaWeatherConditionDataModel) = AreaWeatherConditionDomainModel(
        weather = input.weather.map(weatherDataModelToWeatherDomainModelMapper::toDomain),
        main = weatherBreakDownDataModelToWeatherBreakDownDomainMapper.toDomain(input.main),
        timestamp = input.timestamp,
        dateTime = input.dateTime
    )
}
