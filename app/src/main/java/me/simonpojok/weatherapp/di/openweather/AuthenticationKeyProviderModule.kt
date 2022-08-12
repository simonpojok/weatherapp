package me.simonpojok.weatherapp.di.openweather

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.simonpojok.authentication.AuthenticationKeyDataProvider
import me.simonpojok.authentication.AuthenticationKeyProvider

@Module
@InstallIn(SingletonComponent::class)
object AuthenticationKeyProviderModule {
    @Provides
    fun providesAuthenticationKeyDataProvider(): AuthenticationKeyProvider =
        AuthenticationKeyDataProvider()
}
