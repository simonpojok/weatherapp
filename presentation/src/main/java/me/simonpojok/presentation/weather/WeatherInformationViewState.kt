package me.simonpojok.presentation.weather

import me.simonpojok.presentation.common.ViewState
import me.simonpojok.presentation.weather.model.WeatherBreakDownPresentationModel
import me.simonpojok.presentation.weather.model.WeatherPresentationModel

data class WeatherInformationViewState(
    val weatherBreakDown: WeatherBreakDownPresentationModel = WeatherBreakDownPresentationModel.Empty,
    val weather: WeatherPresentationModel = WeatherPresentationModel.Empty
) : ViewState
