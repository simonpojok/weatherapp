package me.simonpojok.weatherapp.di.weather

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.simonpojok.presentation.common.internal.GeneralDomainToPresentationExceptionMapper

@Module
@InstallIn(SingletonComponent::class)
object WeatherPresentationModule {
    @Provides
    fun providesGeneralDomainToPresentationExceptionMapper() =
        GeneralDomainToPresentationExceptionMapper()
}
