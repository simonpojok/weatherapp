package me.simonpojok.weatherapp.di.weather

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.simonpojok.domain.common.usecase.CoroutineContextProvider
import me.simonpojok.domain.weather.repository.AreaWeatherInformationRepository
import me.simonpojok.domain.weather.usecase.GetAreaWeatherInformationUseCase
import me.simonpojok.domain.weather.usecase.GetAreaWeatherInformationUseCaseImpl
import me.simonpojok.presentation.common.internal.GeneralDomainToPresentationExceptionMapper
import me.simonpojok.presentation.weather.mapper.WeatherBreakDownDomainToPresentationModelMapper
import me.simonpojok.presentation.weather.mapper.WeatherDomainToWeatherPresentationModelMapper

@Module
@InstallIn(SingletonComponent::class)
object WeatherPresentationModule {
    @Provides
    fun providesGeneralDomainToPresentationExceptionMapper() =
        GeneralDomainToPresentationExceptionMapper()

    @Provides
    fun providesGetAreaWeatherInformationUseCase(
        areaWeatherInformationRepository: AreaWeatherInformationRepository,
        coroutineContextProvider: CoroutineContextProvider
    ): GetAreaWeatherInformationUseCase = GetAreaWeatherInformationUseCaseImpl(
        areaWeatherInformationRepository,
        coroutineContextProvider
    )

    @Provides
    fun providesWeatherDomainToWeatherPresentationModelMapper() =
        WeatherDomainToWeatherPresentationModelMapper()

    @Provides
    fun providesWeatherBreakDownDomainToPresentationModelMapper() =
        WeatherBreakDownDomainToPresentationModelMapper()
}
