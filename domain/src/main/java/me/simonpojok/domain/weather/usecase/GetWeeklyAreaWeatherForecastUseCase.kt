package me.simonpojok.domain.weather.usecase

import kotlinx.coroutines.CoroutineScope
import me.simonpojok.domain.common.usecase.BackgroundExecuteUseCase
import me.simonpojok.domain.common.usecase.BaseUseCase
import me.simonpojok.domain.common.usecase.CoroutineContextProvider
import me.simonpojok.domain.weather.model.AreaWeatherConditionDomainModel
import me.simonpojok.domain.weather.model.CoordinateDomainModel
import me.simonpojok.domain.weather.repository.AreaWeatherInformationRepository

interface GetWeeklyAreaWeatherForecastUseCase :
    BaseUseCase<CoordinateDomainModel, List<AreaWeatherConditionDomainModel>>

class GetWeeklyAreaWeatherForecastUseCaseImp(
    private val areaWeatherInformationRepository: AreaWeatherInformationRepository,
    coroutineContextProvider: CoroutineContextProvider
) : GetWeeklyAreaWeatherForecastUseCase,
    BackgroundExecuteUseCase<CoordinateDomainModel, List<AreaWeatherConditionDomainModel>>(
        coroutineContextProvider
    ) {
    override suspend fun executeInBackground(
        request: CoordinateDomainModel,
        coroutineScope: CoroutineScope
    ): List<AreaWeatherConditionDomainModel> =
        areaWeatherInformationRepository.getWeeklyAreaWeatherForecast(request)
}
