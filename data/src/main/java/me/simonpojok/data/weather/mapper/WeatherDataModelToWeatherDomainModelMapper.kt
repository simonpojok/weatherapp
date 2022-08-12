package me.simonpojok.data.weather.mapper

import me.simonpojok.data.common.mapper.DataToDomainMapper
import me.simonpojok.data.weather.model.WeatherDataModel
import me.simonpojok.domain.weather.model.WeatherDomainModel

class WeatherDataModelToWeatherDomainModelMapper :
    DataToDomainMapper<WeatherDataModel, WeatherDomainModel>() {
    override fun map(input: WeatherDataModel) = WeatherDomainModel(
        id = input.id,
        main = input.main,
        description = input.description,
        icon = input.icon
    )
}
