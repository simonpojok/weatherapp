package me.simonpojok.remote.weather.mapper

import me.simonpojok.data.weather.model.WindDataModel
import me.simonpojok.remote.common.mapper.RemoteToDataMapper
import me.simonpojok.remote.weather.model.WindRemoteModel

class WindRemoteModelToWindDataModelMapper : RemoteToDataMapper<WindRemoteModel, WindDataModel>() {
    override fun map(input: WindRemoteModel) = WindDataModel(
        speed = input.speed,
        deg = input.deg,
        gust = input.gust
    )
}
