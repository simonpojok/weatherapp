package me.simonpojok.weatherapp.weather.mapper

import me.simonpojok.presentation.weather.model.WeatherPresentationModel
import me.simonpojok.presentation.weather.model.WeatherPresentationModel.Empty
import me.simonpojok.presentation.weather.model.WeatherPresentationModel.Result
import me.simonpojok.weatherapp.R
import me.simonpojok.weatherapp.common.mapper.PresentationToUiMapper
import me.simonpojok.weatherapp.weather.model.WeatherConditions
import me.simonpojok.weatherapp.weather.model.WeatherConditions.Cloudy
import me.simonpojok.weatherapp.weather.model.WeatherConditions.Rainy
import me.simonpojok.weatherapp.weather.model.WeatherConditions.Sunny
import me.simonpojok.weatherapp.weather.model.WeatherResourceUiModel

class WeatherPresentationToWeatherResourceUiModelMapper(
    private val weatherIconToConditionMapper: WeatherIconToConditionMapper
) : PresentationToUiMapper<WeatherPresentationModel, WeatherResourceUiModel>() {
    override fun map(input: WeatherPresentationModel) = when (input) {
        is Empty -> WeatherResourceUiModel.Empty
        is Result -> WeatherResourceUiModel.Result(
            headerImage = weatherIconToConditionMapper.map(input.icon).toDrawable(),
            backgroundColor = weatherIconToConditionMapper.map(input.icon).toColor()
        )
    }

    private fun WeatherConditions.toDrawable() = when (this) {
        Sunny -> R.drawable.forest_sunny
        Rainy -> R.drawable.forest_rainy
        Cloudy -> R.drawable.forest_cloudy
    }

    private fun WeatherConditions.toColor() = when (this) {
        Sunny -> R.color.sunny
        Rainy -> R.color.rainy
        Cloudy -> R.color.cloudy
    }
}
