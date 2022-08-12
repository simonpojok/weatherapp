package me.simonpojok.weatherapp.weather.model

sealed class WeatherConditions {
    object Sunny: WeatherConditions()
    object Cloudy: WeatherConditions()
    object Rainy: WeatherConditions()
}
