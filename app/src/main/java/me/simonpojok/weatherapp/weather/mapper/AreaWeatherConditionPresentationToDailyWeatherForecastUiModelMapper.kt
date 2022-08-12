package me.simonpojok.weatherapp.weather.mapper

import android.content.res.Resources
import android.icu.text.SimpleDateFormat
import me.simonpojok.presentation.weather.model.AreaWeatherConditionPresentationModel
import me.simonpojok.presentation.weather.model.WeatherBreakDownPresentationModel
import me.simonpojok.presentation.weather.model.WeatherPresentationModel
import me.simonpojok.weatherapp.R
import me.simonpojok.weatherapp.common.mapper.PresentationToUiMapper
import me.simonpojok.weatherapp.common.toCelsius
import me.simonpojok.weatherapp.weather.model.DailyWeatherForecastUiModel
import me.simonpojok.weatherapp.weather.model.WeatherConditions
import me.simonpojok.weatherapp.weather.model.WeatherConditions.Rainy
import me.simonpojok.weatherapp.weather.model.WeatherConditions.Sunny
import java.sql.Timestamp
import java.util.Date
import java.util.Locale

const val DEFAULT_ICON_NAME = "01d"

class AreaWeatherConditionPresentationToDailyWeatherForecastUiModelMapper(
    private val resources: Resources,
    private val weatherIconToConditionMapper: WeatherIconToConditionMapper
) :
    PresentationToUiMapper<AreaWeatherConditionPresentationModel, DailyWeatherForecastUiModel>() {
    override fun map(input: AreaWeatherConditionPresentationModel) = DailyWeatherForecastUiModel(
        temperature = resources.getString(
            R.string.degree_label,
            String.format("%.0f", input.weatherBreakDown.toTemperature().toCelsius())
        ),
        dayOfWeek = input.timestamp.dayOfWeek(),
        conditionImage = weatherIconToConditionMapper.map(input.weather.toIconName())
            .toImageResource()
    )

    private fun WeatherBreakDownPresentationModel.toTemperature() = when (this) {
        is WeatherBreakDownPresentationModel.Result -> this.temp
        else -> 0.0
    }

    private fun Long.dayOfWeek(): String {
        val stamp = Timestamp(System.currentTimeMillis() + this)
        val date = Date(stamp.time)
        val sdf = SimpleDateFormat("EEEE", Locale.getDefault())
        return sdf.format(date)!!
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
}
