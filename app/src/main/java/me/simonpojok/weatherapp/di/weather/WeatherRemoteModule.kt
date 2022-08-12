package me.simonpojok.weatherapp.di.weather

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import me.simonpojok.authentication.AuthenticationKeyProvider
import me.simonpojok.data.weather.datasource.RemoteWeatherDataSource
import me.simonpojok.remote.service.OpenWeatherService
import me.simonpojok.remote.source.WeatherInformationRemoteSource
import me.simonpojok.remote.weather.mapper.AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://api.openweathermap.org"

@Module
@InstallIn(ActivityComponent::class)
object WeatherRemoteModule {

    @Provides
    fun providesRemoteWeatherDataSource(
        openWeatherService: OpenWeatherService,
        authenticationKeyProvider: AuthenticationKeyProvider,
        areaWeatherConditionMapper: AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper
    ): RemoteWeatherDataSource = WeatherInformationRemoteSource(
        openWeatherService,
        authenticationKeyProvider,
        areaWeatherConditionMapper
    )

    @Singleton
    @Provides
    fun providesRetrofit(): Retrofit {
        val logger = HttpLoggingInterceptor()
        logger.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
        client.addInterceptor(logger)

        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BASE_URL)
            .client(client.build())
            .build()
    }

    @Provides
    @Singleton
    fun providesAgencyService(retrofit: Retrofit): OpenWeatherService {
        return retrofit.create(OpenWeatherService::class.java)
    }
}
