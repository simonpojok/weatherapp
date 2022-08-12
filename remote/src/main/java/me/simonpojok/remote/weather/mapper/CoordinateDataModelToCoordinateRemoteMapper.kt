package me.simonpojok.remote.weather.mapper

import me.simonpojok.data.weather.model.CoordinateDataModel
import me.simonpojok.remote.common.mapper.DataToRemoteMapper
import me.simonpojok.remote.weather.model.CoordinateRemoteModel

class CoordinateDataModelToCoordinateRemoteMapper :
    DataToRemoteMapper<CoordinateDataModel, CoordinateRemoteModel>() {
    override fun map(input: CoordinateDataModel) = CoordinateRemoteModel(
        lat = input.lat,
        lon = input.lon
    )
}
