package me.simonpojok.weatherapp.weather.model

import androidx.annotation.DrawableRes

data class DailyWeatherForecastUiModel(
    val dayOfWeek: String,
    val temperature: String,
    @DrawableRes
    val conditionImage: Int
)
