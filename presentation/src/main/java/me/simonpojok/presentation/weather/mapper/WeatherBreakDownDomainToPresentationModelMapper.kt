package me.simonpojok.presentation.weather.mapper

import me.simonpojok.domain.weather.model.WeatherBreakDownDomainModel
import me.simonpojok.presentation.common.mappers.DomainToPresentationMapper
import me.simonpojok.presentation.weather.model.WeatherBreakDownPresentationModel

class WeatherBreakDownDomainToPresentationModelMapper :
    DomainToPresentationMapper<WeatherBreakDownDomainModel, WeatherBreakDownPresentationModel>() {
    override fun map(input: WeatherBreakDownDomainModel) = WeatherBreakDownPresentationModel.Result(
        temp = input.temp,
        feels_like = input.feels_like,
        tempMin = input.temp_min,
        tempMax = input.temp_max,
        pressure = input.pressure,
        humidity = input.humidity
    )
}
