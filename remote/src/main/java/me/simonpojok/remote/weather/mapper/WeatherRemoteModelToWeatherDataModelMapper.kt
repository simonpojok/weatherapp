package me.simonpojok.remote.weather.mapper

import me.simonpojok.data.weather.model.WeatherDataModel
import me.simonpojok.remote.common.mapper.RemoteToDataMapper
import me.simonpojok.remote.weather.model.WeatherRemoteModel

class WeatherRemoteModelToWeatherDataModelMapper :
    RemoteToDataMapper<WeatherRemoteModel, WeatherDataModel>() {
    override fun map(input: WeatherRemoteModel) = WeatherDataModel(
        id = input.id,
        main = input.main,
        description = input.description,
        icon = input.icon
    )
}
