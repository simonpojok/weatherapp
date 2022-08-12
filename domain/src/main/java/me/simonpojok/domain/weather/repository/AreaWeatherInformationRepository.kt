package me.simonpojok.domain.weather.repository

import me.simonpojok.domain.weather.model.AreaWeatherConditionDomainModel
import me.simonpojok.domain.weather.model.CoordinateDomainModel

interface AreaWeatherInformationRepository {
    suspend fun getAreaWeatherCondition(coordinateDomainModel: CoordinateDomainModel): AreaWeatherConditionDomainModel
    suspend fun getWeeklyAreaWeatherForecast(coordinateDomainModel: CoordinateDomainModel): List<AreaWeatherConditionDomainModel>
}
