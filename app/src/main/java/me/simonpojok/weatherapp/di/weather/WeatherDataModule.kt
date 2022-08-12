package me.simonpojok.weatherapp.di.weather

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.simonpojok.authentication.AuthenticationKeyProvider
import me.simonpojok.data.weather.datasource.RemoteWeatherDataSource
import me.simonpojok.data.weather.mapper.AreaWeatherConditionDataToAreaWeatherConditionDomainModelMapper
import me.simonpojok.data.weather.mapper.CoordinateDomainToCoordinateRemoteModelMapper
import me.simonpojok.data.weather.mapper.WeatherBreakDownDataModelToWeatherBreakDownDomainMapper
import me.simonpojok.data.weather.mapper.WeatherDataModelToWeatherDomainModelMapper
import me.simonpojok.data.weather.repository.WeatherInformationDataRepository
import me.simonpojok.domain.weather.repository.AreaWeatherInformationRepository
import me.simonpojok.remote.service.OpenWeatherService
import me.simonpojok.remote.source.WeatherInformationRemoteSource
import me.simonpojok.remote.weather.mapper.AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper
import me.simonpojok.remote.weather.mapper.CloudsRemoteModelToCloudsDataModelMapper
import me.simonpojok.remote.weather.mapper.CoordinateRemoteModelToCoordinateDataMapper
import me.simonpojok.remote.weather.mapper.SystemRemoteModelToSystemDataModelMapper
import me.simonpojok.remote.weather.mapper.WeatherBreakDownRemoteModelToWeatherBreakDownDataMapper
import me.simonpojok.remote.weather.mapper.WeatherRemoteModelToWeatherDataModelMapper
import me.simonpojok.remote.weather.mapper.WindRemoteModelToWindDataModelMapper
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

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

    private const val BASE_URL = "https://api.openweathermap.org"

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

    @Provides
    fun providesAreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper(
        weatherRemoteMapper: WeatherRemoteModelToWeatherDataModelMapper,
        weatherBreakDataMapper: WeatherBreakDownRemoteModelToWeatherBreakDownDataMapper,
    ) =
        AreaWeatherConditionRemoteModelToAreaWeatherConditionDataModelMapper(
            weatherRemoteMapper, weatherBreakDataMapper
        )

    @Provides
    fun providesCoordinateRemoteModelToCoordinateDataMapper() =
        CoordinateRemoteModelToCoordinateDataMapper()

    @Provides
    fun providesWeatherRemoteModelToWeatherDataModelMapper() =
        WeatherRemoteModelToWeatherDataModelMapper()

    @Provides
    fun providesWeatherBreakDownRemoteModelToWeatherBreakDownDataMapper() =
        WeatherBreakDownRemoteModelToWeatherBreakDownDataMapper()

    @Provides
    fun providesCloudsRemoteModelToCloudsDataModelMapper() =
        CloudsRemoteModelToCloudsDataModelMapper()

    @Provides
    fun providesSystemRemoteModelToSystemDataModelMapper() =
        SystemRemoteModelToSystemDataModelMapper()

    @Provides
    fun providesWindRemoteModelToWindDataModelMapper() = WindRemoteModelToWindDataModelMapper()
}
