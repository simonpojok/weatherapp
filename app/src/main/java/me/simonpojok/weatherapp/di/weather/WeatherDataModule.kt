package me.simonpojok.weatherapp.di.weather

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.simonpojok.data.weather.datasource.RemoteWeatherDataSource
import me.simonpojok.data.weather.mapper.AreaWeatherConditionDataToAreaWeatherConditionDomainModelMapper
import me.simonpojok.data.weather.mapper.CoordinateDomainToCoordinateRemoteModelMapper
import me.simonpojok.data.weather.mapper.WeatherBreakDownDataModelToWeatherBreakDownDomainMapper
import me.simonpojok.data.weather.mapper.WeatherDataModelToWeatherDomainModelMapper
import me.simonpojok.data.weather.repository.WeatherInformationDataRepository
import me.simonpojok.domain.weather.repository.AreaWeatherInformationRepository

@Module
@InstallIn(SingletonComponent::class)
object WeatherDataModule {

    @Provides
    fun providesAreaWeatherInformationRepository(
        remoteWeatherDataSource: RemoteWeatherDataSource,
        coordinateRemoteModelMapper: CoordinateDomainToCoordinateRemoteModelMapper,
        areaWeatherConditionDomainMapper: AreaWeatherConditionDataToAreaWeatherConditionDomainModelMapper
    ): AreaWeatherInformationRepository =
        WeatherInformationDataRepository(
            remoteWeatherDataSource,
            coordinateRemoteModelMapper,
            areaWeatherConditionDomainMapper
        )

    @Provides
    fun providesCoordinateDomainToCoordinateRemoteModelMapper() =
        CoordinateDomainToCoordinateRemoteModelMapper()

    @Provides
    fun providesWeatherBreakDownDataModelToWeatherBreakDownDomainMapper() =
        WeatherBreakDownDataModelToWeatherBreakDownDomainMapper()

    @Provides
    fun providesWeatherDataModelToWeatherDomainModelMapper() =
        WeatherDataModelToWeatherDomainModelMapper()

    @Provides
    fun providesAreaWeatherConditionDataToAreaWeatherConditionDomainModelMapper(
        weatherBreakDownDataModelToWeatherBreakDownDomainMapper: WeatherBreakDownDataModelToWeatherBreakDownDomainMapper,
        weatherDataModelToWeatherDomainModelMapper: WeatherDataModelToWeatherDomainModelMapper
    ) = AreaWeatherConditionDataToAreaWeatherConditionDomainModelMapper(
        weatherBreakDownDataModelToWeatherBreakDownDomainMapper,
        weatherDataModelToWeatherDomainModelMapper
    )
}
