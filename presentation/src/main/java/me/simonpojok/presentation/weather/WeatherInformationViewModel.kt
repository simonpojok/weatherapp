package me.simonpojok.presentation.weather

import dagger.hilt.android.lifecycle.HiltViewModel
import me.simonpojok.domain.weather.model.AreaWeatherConditionDomainModel
import me.simonpojok.domain.weather.model.CoordinateDomainModel
import me.simonpojok.domain.weather.usecase.GetAreaWeatherInformationUseCase
import me.simonpojok.domain.weather.usecase.GetWeeklyAreaWeatherForecastUseCase
import me.simonpojok.presentation.common.BaseViewModel
import me.simonpojok.presentation.common.DialogCommand
import me.simonpojok.presentation.common.internal.GeneralDomainToPresentationExceptionMapper
import me.simonpojok.presentation.common.usecaseexecutor.UseCaseExecutorProvider
import me.simonpojok.presentation.weather.mapper.AreaWeatherConditionDomainToWeeklyAreaWeatherModelMapper
import me.simonpojok.presentation.weather.mapper.WeatherBreakDownDomainToPresentationModelMapper
import me.simonpojok.presentation.weather.mapper.WeatherDomainToWeatherPresentationModelMapper
import javax.inject.Inject

@HiltViewModel
class WeatherInformationViewModel @Inject constructor(
    private val weeklyAreaWeatherDomainMapper: AreaWeatherConditionDomainToWeeklyAreaWeatherModelMapper,
    private val weatherDomainToWeatherPresentationModelMapper: WeatherDomainToWeatherPresentationModelMapper,
    private val weatherBreakDownDomainToPresentationModelMapper: WeatherBreakDownDomainToPresentationModelMapper,
    private val getWeeklyAreaWeatherForecastUseCase: GetWeeklyAreaWeatherForecastUseCase,
    private val getAreaWeatherInformationUseCase: GetAreaWeatherInformationUseCase,
    generalDomainToPresentationExceptionMapper: GeneralDomainToPresentationExceptionMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider
) : BaseViewModel<WeatherInformationViewState, DialogCommand>(
    useCaseExecutorProvider = useCaseExecutorProvider,
    exceptionDomainToPresentationMapper = generalDomainToPresentationExceptionMapper
) {
    override fun initialState() = WeatherInformationViewState()

    override fun onFragmentViewCreated() {
        onGetWeatherInformationAction(lat = 1.3733, lon = 32.2903)
        onGetWeeklyAreaWeatherForecast(lat = 1.3733, lon = 32.2903)
    }

    private fun onGetWeatherInformationAction(lon: Double, lat: Double) {
        updateState { lastState ->
            lastState.copy(
                isLoading = true
            )
        }

        useCaseExecutor.execute(
            value = CoordinateDomainModel(lon, lat),
            useCase = getAreaWeatherInformationUseCase,
            callback = ::updateWeatherInformationState,
            onError = { error ->
                print(error.toString())
            }
        )
    }

    private fun onGetWeeklyAreaWeatherForecast(lon: Double, lat: Double) {
        useCaseExecutor.execute(
            value = CoordinateDomainModel(lon, lat),
            useCase = getWeeklyAreaWeatherForecastUseCase,
            callback = ::updateWeeklyAreaWeatherForecastState,
            onError = { error ->
                print(error.toString())
            }
        )
    }

    private fun updateWeeklyAreaWeatherForecastState(forcasts: List<AreaWeatherConditionDomainModel>) {
        updateState { lastState ->
            lastState.copy(
                forcasts = weeklyAreaWeatherDomainMapper.toPresentation(forcasts)
            )
        }
    }

    private fun updateWeatherInformationState(weatherInformation: AreaWeatherConditionDomainModel) {
        weatherDomainToWeatherPresentationModelMapper.temperature = weatherInformation.main.temp_max

        updateState { lastState ->
            lastState.copy(
                isLoading = false,
                weather = weatherDomainToWeatherPresentationModelMapper.toPresentation(
                    weatherInformation.weather.last()
                ),
                weatherBreakDown = weatherBreakDownDomainToPresentationModelMapper.toPresentation(
                    weatherInformation.main
                )
            )
        }
    }
}
