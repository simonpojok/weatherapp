package me.simonpojok.weatherapp.di.weather

import android.content.Context
import android.content.res.Resources
import com.google.android.gms.location.LocationServices
import com.google.android.gms.tasks.CancellationTokenSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import me.simonpojok.weatherapp.navigation.GlobalDestinationMapper
import me.simonpojok.weatherapp.weather.WeatherInformationUiDestinationMapper
import me.simonpojok.weatherapp.weather.mapper.AreaWeatherConditionPresentationToDailyWeatherForecastUiModelMapper
import me.simonpojok.weatherapp.weather.mapper.FahrenheitToCelsiusMapper
import me.simonpojok.weatherapp.weather.mapper.WeatherBreakDownPresentationToUIModelMapper
import me.simonpojok.weatherapp.weather.mapper.WeatherIconToConditionMapper
import me.simonpojok.weatherapp.weather.mapper.WeatherPresentationToUiModelMapper
import me.simonpojok.weatherapp.weather.mapper.WeatherPresentationToWeatherResourceUiModelMapper

@Module
@InstallIn(ActivityComponent::class)
object WeatherUiModule {

    @Provides
    fun providesWeatherInformationUiDestinationMapper() = WeatherInformationUiDestinationMapper()

    @Provides
    fun providesGlobalDestinationMapper() = GlobalDestinationMapper()

    @Provides
    fun providesResources(@ApplicationContext appContext: Context): Resources =
        appContext.resources

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

    @Provides
    fun providesWeatherPresentationToWeatherResourceUiModelMapper(
        weatherIconToConditionMapper: WeatherIconToConditionMapper
    ) = WeatherPresentationToWeatherResourceUiModelMapper(weatherIconToConditionMapper)

    @Provides
    fun providesAreaWeatherConditionPresentationToDailyWeatherForecastUiModelMapper(
        resources: Resources,
        weatherIconToConditionMapper: WeatherIconToConditionMapper,
        fahrenheitToCelsiusMapper: FahrenheitToCelsiusMapper
    ) = AreaWeatherConditionPresentationToDailyWeatherForecastUiModelMapper(
        resources,
        weatherIconToConditionMapper,
        fahrenheitToCelsiusMapper
    )

    @Provides
    fun providesFusedLocationProviderClient(@ApplicationContext appContext: Context) =
        LocationServices.getFusedLocationProviderClient(appContext)

    @Provides
    fun providesCancellationTokenSource() = CancellationTokenSource()

    @Provides
    fun providesFahrenheitToCelsiusMapper() = FahrenheitToCelsiusMapper()
}
