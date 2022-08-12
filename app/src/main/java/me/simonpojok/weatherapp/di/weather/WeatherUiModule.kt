package me.simonpojok.weatherapp.di.weather

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import me.simonpojok.weatherapp.navigation.GlobalDestinationMapper
import me.simonpojok.weatherapp.weather.WeatherInformationUiDestinationMapper

@Module
@InstallIn(ActivityComponent::class)
object WeatherUiModule {

    @Provides
    fun providesWeatherInformationUiDestinationMapper() = WeatherInformationUiDestinationMapper()

    @Provides
    fun providesGlobalDestinationMapper() = GlobalDestinationMapper()
}
