package me.simonpojok.presentation.weather.mapper

import me.simonpojok.domain.weather.model.WeatherDomainModel
import me.simonpojok.presentation.common.mappers.DomainToPresentationMapper
import me.simonpojok.presentation.weather.model.WeatherPresentationModel
import kotlin.properties.Delegates

class WeatherDomainToWeatherPresentationModelMapper :
    DomainToPresentationMapper<WeatherDomainModel, WeatherPresentationModel>() {
    var temperature by Delegates.notNull<Double>()

    override fun map(input: WeatherDomainModel) = WeatherPresentationModel.Result(
        id = input.id,
        main = input.main,
        description = input.description,
        icon = input.icon,
        temperature = temperature
    )
}
