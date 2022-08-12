package me.simonpojok.weatherapp.weather.model

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes

sealed class WeatherResourceUiModel {
    object Empty : WeatherResourceUiModel()
    data class Result(
        @DrawableRes
        val headerImage: Int,
        @ColorRes
        val backgroundColor: Int
    ) : WeatherResourceUiModel()
}
