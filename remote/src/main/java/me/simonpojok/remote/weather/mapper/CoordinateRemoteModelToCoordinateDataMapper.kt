package me.simonpojok.remote.weather.mapper

import me.simonpojok.data.weather.model.CoordinateDataModel
import me.simonpojok.remote.common.mapper.DataToRemoteMapper
import me.simonpojok.remote.common.mapper.RemoteToDataMapper
import me.simonpojok.remote.weather.model.CoordinateRemoteModel

class CoordinateRemoteModelToCoordinateDataMapper :
    RemoteToDataMapper<CoordinateRemoteModel, CoordinateDataModel>() {
    override fun map(input: CoordinateRemoteModel) = CoordinateDataModel(
        lat = input.lat,
        lon = input.lon
    )
}
