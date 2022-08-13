package me.simonpojok.weatherapp.weather.mapper

import android.content.res.Resources
import me.simonpojok.presentation.weather.model.WeatherPresentationModel
import me.simonpojok.presentation.weather.model.WeatherPresentationModel.Empty
import me.simonpojok.presentation.weather.model.WeatherPresentationModel.Result
import me.simonpojok.weatherapp.R
import me.simonpojok.weatherapp.common.mapper.PresentationToUiMapper
import me.simonpojok.weatherapp.common.toCelsius
import me.simonpojok.weatherapp.weather.model.WeatherConditions
import me.simonpojok.weatherapp.weather.model.WeatherUiModel
import java.util.Locale

class WeatherPresentationToUiModelMapper(
    private val resources: Resources,
    private val weatherIconToConditionMapper: WeatherIconToConditionMapper
) : PresentationToUiMapper<WeatherPresentationModel, WeatherUiModel>() {
    override fun map(input: WeatherPresentationModel) = when (input) {
        is Empty -> WeatherUiModel.Empty
        is Result -> WeatherUiModel.Result(
            temperature = resources.getString(
                R.string.degree_label,
                String.format("%.0f", input.temperature.toCelsius())
            ),
            condition = weatherIconToConditionMapper.map(input.icon).toLocalizedString()
                .uppercase(Locale.getDefault())
        )
    }

    private fun WeatherConditions.toLocalizedString() = when (this) {
        WeatherConditions.Sunny -> resources.getString(R.string.weather_information_condition_sunny_label)
        WeatherConditions.Rainy -> resources.getString(R.string.weather_information_condition_rainy_label)
        WeatherConditions.Cloudy -> resources.getString(R.string.weather_information_condition_cloudy_label)
    }
}
