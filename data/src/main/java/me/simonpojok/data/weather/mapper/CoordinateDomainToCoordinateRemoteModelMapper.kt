package me.simonpojok.data.weather.mapper

import me.simonpojok.data.common.mapper.DomainToDataMapper
import me.simonpojok.data.weather.model.CoordinateDataModel
import me.simonpojok.domain.weather.model.CoordinateDomainModel

class CoordinateDomainToCoordinateRemoteModelMapper :
    DomainToDataMapper<CoordinateDomainModel, CoordinateDataModel>() {
    override fun map(input: CoordinateDomainModel) = CoordinateDataModel(
        lat = input.lat,
        lon = input.lon
    )
}
