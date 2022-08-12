package me.simonpojok.weatherapp.di.weather

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
object WeatherRemoteModule {
}
