package me.simonpojok.weatherapp.weather.mapper

import android.content.res.Resources
import me.simonpojok.presentation.weather.model.AreaWeatherConditionPresentationModel
import me.simonpojok.presentation.weather.model.WeatherBreakDownPresentationModel
import me.simonpojok.presentation.weather.model.WeatherPresentationModel
import me.simonpojok.weatherapp.R
import me.simonpojok.weatherapp.common.mapper.PresentationToUiMapper
import me.simonpojok.weatherapp.weather.model.DailyWeatherForecastUiModel
import me.simonpojok.weatherapp.weather.model.WeatherConditions
import me.simonpojok.weatherapp.weather.model.WeatherConditions.Rainy
import me.simonpojok.weatherapp.weather.model.WeatherConditions.Sunny

const val DEFAULT_ICON_NAME = "02n"

class AreaWeatherConditionPresentationToDailyWeatherForecastUiModelMapper(
    private val resources: Resources,
    private val weatherIconToConditionMapper: WeatherIconToConditionMapper,
    private val fahrenheitToCelsiusMapper: FahrenheitToCelsiusMapper
) :
    PresentationToUiMapper<AreaWeatherConditionPresentationModel, DailyWeatherForecastUiModel>() {
    override fun map(input: AreaWeatherConditionPresentationModel) = DailyWeatherForecastUiModel(
        temperature = resources.getString(
            R.string.degree_label,
            String.format("%.0f", input.weatherBreakDown.toTemperature().toCelsius())
        ),
        dayOfWeek = input.dateTime,
        conditionImage = weatherIconToConditionMapper.map(input.weather.toIconName())
            .toImageResource()
    )

    private fun WeatherBreakDownPresentationModel.toTemperature() = when (this) {
        is WeatherBreakDownPresentationModel.Result -> this.temp
        else -> 0.0
    }

    private fun WeatherConditions.toImageResource() = when (this) {
        is Sunny -> R.drawable.partlysunny
        is Rainy -> R.drawable.rain
        else -> R.drawable.clear
    }

    private fun WeatherPresentationModel.toIconName() = when (this) {
        is WeatherPresentationModel.Result -> this.icon
        else -> DEFAULT_ICON_NAME
    }

    private fun Double.toCelsius() = fahrenheitToCelsiusMapper.toUi(this)
}
