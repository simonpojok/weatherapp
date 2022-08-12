package me.simonpojok.remote.weather.mapper

import me.simonpojok.data.weather.model.WeatherBreakDownDataModel
import me.simonpojok.remote.common.mapper.RemoteToDataMapper
import me.simonpojok.remote.weather.model.WeatherBreakDownRemoteModel

class WeatherBreakDownRemoteModelToWeatherBreakDownDataMapper :
    RemoteToDataMapper<WeatherBreakDownRemoteModel, WeatherBreakDownDataModel>() {
    override fun map(input: WeatherBreakDownRemoteModel) = WeatherBreakDownDataModel(
        temp = input.temp,
        feels_like = input.feels_like,
        temp_min = input.temp_min,
        temp_max = input.temp_max,
        pressure = input.pressure,
        humidity = input.humidity
    )
}
