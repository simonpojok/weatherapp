package me.simonpojok.remote.service

import me.simonpojok.remote.weather.model.AreaWeatherConditionRemoteModel
import me.simonpojok.remote.weather.model.AreaWeatherForecastRemoteModel
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface OpenWeatherService {
    @GET("/data/2.5/weather")
    suspend fun getCurrentWeatherData(
        @QueryMap query: Map<String, String>
    ): AreaWeatherConditionRemoteModel

    @GET("/data/2.5/forecast")
    suspend fun getCurrentWeatherForecastData(
        @QueryMap query: Map<String, String>
    ): AreaWeatherForecastRemoteModel
}
