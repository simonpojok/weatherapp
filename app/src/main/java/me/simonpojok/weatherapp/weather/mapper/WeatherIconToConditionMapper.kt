package me.simonpojok.weatherapp.weather.mapper

import me.simonpojok.weatherapp.weather.model.WeatherConditions
import me.simonpojok.weatherapp.weather.model.WeatherConditions.Cloudy
import me.simonpojok.weatherapp.weather.model.WeatherConditions.Rainy
import me.simonpojok.weatherapp.weather.model.WeatherConditions.Sunny

class WeatherIconToConditionMapper {
    fun map(icon: String): WeatherConditions {
        val clearIcons = listOf("01d", "01n")
        val cloudyIcons = listOf("02d", "02n", "03d", "03n", "04d", "04n")
        val rainyIcons = listOf("09d", "09n", "10n", "10d", "11d", "11n")

        if (clearIcons.contains(icon)) return Sunny
        if (cloudyIcons.contains(icon)) return Cloudy
        if (rainyIcons.contains(icon)) return Rainy

        return Sunny
    }
}
