package me.simonpojok.weatherapp.weather.mapper

import android.content.res.Resources
import me.simonpojok.presentation.weather.model.WeatherBreakDownPresentationModel
import me.simonpojok.presentation.weather.model.WeatherBreakDownPresentationModel.Empty
import me.simonpojok.presentation.weather.model.WeatherBreakDownPresentationModel.Result
import me.simonpojok.weatherapp.R
import me.simonpojok.weatherapp.common.mapper.PresentationToUiMapper
import me.simonpojok.weatherapp.common.toCelsius
import me.simonpojok.weatherapp.weather.model.WeatherBreakDownUiModel

class WeatherBreakDownPresentationToUIModelMapper(
    private val resources: Resources
) : PresentationToUiMapper<WeatherBreakDownPresentationModel, WeatherBreakDownUiModel>() {
    override fun map(input: WeatherBreakDownPresentationModel) = when (input) {
        Empty -> WeatherBreakDownUiModel.Empty
        is Result -> WeatherBreakDownUiModel.Result(
            maxTemperature = resources.getString(
                R.string.degree_label,
                String.format("%.0f", input.tempMax.toCelsius())
            ),
            minTemperature = resources.getString(
                R.string.degree_label,
                String.format("%.0f", input.tempMin.toCelsius())
            ),
            currentTemperature = resources.getString(
                R.string.degree_label,
                String.format("%.0f", input.temp.toCelsius())
            )
        )
    }
}
