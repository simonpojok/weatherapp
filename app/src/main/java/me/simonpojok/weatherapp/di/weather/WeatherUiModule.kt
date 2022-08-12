package me.simonpojok.weatherapp.di.weather

import android.app.Application
import android.content.res.Resources
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import me.simonpojok.weatherapp.navigation.GlobalDestinationMapper
import me.simonpojok.weatherapp.weather.WeatherInformationUiDestinationMapper
import me.simonpojok.weatherapp.weather.mapper.WeatherBreakDownPresentationToUIModelMapper
import me.simonpojok.weatherapp.weather.mapper.WeatherIconToConditionMapper
import me.simonpojok.weatherapp.weather.mapper.WeatherPresentationToUiModelMapper

@Module
@InstallIn(ActivityComponent::class)
object WeatherUiModule {

    @Provides
    fun providesWeatherInformationUiDestinationMapper() = WeatherInformationUiDestinationMapper()

    @Provides
    fun providesGlobalDestinationMapper() = GlobalDestinationMapper()

    @Provides
    fun providesResources(@ApplicationContext application: Application): Resources =
        application.resources

    @Provides
    fun providesWeatherIconToConditionMapper() = WeatherIconToConditionMapper()

    @Provides
    fun providesWeatherPresentationToUiModelMapper(
        resources: Resources,
        weatherIconToConditionMapper: WeatherIconToConditionMapper
    ) = WeatherPresentationToUiModelMapper(
        resources, weatherIconToConditionMapper
    )

    @Provides
    fun providesWeatherBreakDownPresentationToUIModelMapper(
        resources: Resources
    ) = WeatherBreakDownPresentationToUIModelMapper(resources)
}
