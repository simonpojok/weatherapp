package me.simonpojok.data.weather.mapper

import me.simonpojok.data.common.mapper.DataToDomainMapper
import me.simonpojok.data.weather.model.WeatherBreakDownDataModel
import me.simonpojok.domain.weather.model.WeatherBreakDownDomainModel

class WeatherBreakDownDataModelToWeatherBreakDownDomainMapper :
    DataToDomainMapper<WeatherBreakDownDataModel, WeatherBreakDownDomainModel>() {
    override fun map(input: WeatherBreakDownDataModel) = WeatherBreakDownDomainModel(
        temp = input.temp,
        feels_like = input.feels_like,
        temp_min = input.temp_min,
        temp_max = input.temp_max,
        pressure = input.pressure,
        humidity = input.humidity
    )
}
