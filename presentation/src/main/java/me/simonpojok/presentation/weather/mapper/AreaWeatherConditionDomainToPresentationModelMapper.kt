package me.simonpojok.presentation.weather.mapper

import me.simonpojok.domain.weather.model.AreaWeatherConditionDomainModel
import me.simonpojok.presentation.common.mappers.DomainToPresentationMapper
import me.simonpojok.presentation.weather.model.AreaWeatherConditionPresentationModel

class AreaWeatherConditionDomainToPresentationModelMapper(
    private val weatherDomainMapper: WeatherDomainToWeatherPresentationModelMapper,
    private val weatherBreakDownMapper: WeatherBreakDownDomainToPresentationModelMapper,
) : DomainToPresentationMapper<AreaWeatherConditionDomainModel, AreaWeatherConditionPresentationModel>() {
    override fun map(input: AreaWeatherConditionDomainModel): AreaWeatherConditionPresentationModel {
        weatherDomainMapper.temperature = input.main.temp_max

        return AreaWeatherConditionPresentationModel(
            timestamp = input.timestamp,
            weather = weatherDomainMapper.toPresentation(input.weather.first()),
            weatherBreakDown = weatherBreakDownMapper.toPresentation(input.main),
            dateTime = input.dateTime
        )
    }
}
