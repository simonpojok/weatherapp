package me.simonpojok.domain.weather.repository

import me.simonpojok.domain.weather.model.CoordinateDomainModel
import me.simonpojok.domain.weather.model.AreaWeatherConditionDomainModel

interface AreaWeatherInformationRepository {
    suspend fun getAreaWeatherCondition(coordinateDomainModel: CoordinateDomainModel): AreaWeatherConditionDomainModel
}
