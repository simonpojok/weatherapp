package me.simonpojok.remote.weather.mapper

import me.simonpojok.data.weather.model.CloudsDataModel
import me.simonpojok.remote.common.mapper.RemoteToDataMapper
import me.simonpojok.remote.weather.model.CloudsRemoteModel

class CloudsRemoteModelToCloudsDataModelMapper :
    RemoteToDataMapper<CloudsRemoteModel, CloudsDataModel>() {
    override fun map(input: CloudsRemoteModel) = CloudsDataModel(
        all = input.all
    )
}
