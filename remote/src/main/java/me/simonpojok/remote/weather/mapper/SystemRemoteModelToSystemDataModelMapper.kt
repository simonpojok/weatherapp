package me.simonpojok.remote.weather.mapper

import me.simonpojok.data.weather.model.SystemDataModel
import me.simonpojok.remote.common.mapper.RemoteToDataMapper
import me.simonpojok.remote.weather.model.SystemRemoteModel

class SystemRemoteModelToSystemDataModelMapper :
    RemoteToDataMapper<SystemRemoteModel, SystemDataModel>() {
    override fun map(input: SystemRemoteModel) = SystemDataModel(
        type = input.type,
        id = input.id,
        country = input.country,
        sunrise = input.sunrise,
        sunset = input.sunset
    )
}
