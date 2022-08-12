package me.simonpojok.remote.service

import me.simonpojok.remote.weather.model.AreaWeatherConditionRemoteModel
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface OpenWeatherService {
    @GET("/data/2.5/weather")
    suspend fun getCurrentWeatherData(
        @QueryMap query: Map<String, String>
    ): AreaWeatherConditionRemoteModel
}
