package me.simonpojok.presentation.weather

import me.simonpojok.presentation.common.ViewState

data class WeatherInformationViewState(
    val name: String = ""
): ViewState
