package me.simonpojok.remote.service

import me.simonpojok.data.weather.model.AreaWeatherConditionDataModel
import retrofit2.http.GET
import retrofit2.http.Path

interface OpenWeatherService {
    @GET("/data/2.5/weather?lat={lat}&lon={lon}&appid={apiKey}")
    suspend fun getCurrentWeatherData(
        @Path("lat") lat: Int,
        @Path("lon") log: Int,
        @Path("apiKey") apiKey: String
    ): AreaWeatherConditionDataModel
}
