package me.simonpojok.weatherapp.weather.mapper

import me.simonpojok.weatherapp.R
import me.simonpojok.weatherapp.common.mapper.PresentationToUiMapper
import me.simonpojok.weatherapp.weather.model.WeatherConditions
import me.simonpojok.weatherapp.weather.model.WeatherConditions.Rainy
import me.simonpojok.weatherapp.weather.model.WeatherConditions.Sunny
import me.simonpojok.weatherapp.weather.model.WeatherConditions.Cloudy
import javax.inject.Inject

class WeatherConditionsToDrawableResourceMapper @Inject constructor() :
    PresentationToUiMapper<WeatherConditions, Int>() {
    override fun map(input: WeatherConditions) = when (input) {
        Sunny -> R.drawable.partlysunny
        Rainy -> R.drawable.rain
        Cloudy -> R.drawable.clear
    }
}
