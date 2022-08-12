package me.simonpojok.weatherapp.weather.widgets

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import me.simonpojok.weatherapp.R
import me.simonpojok.weatherapp.weather.model.WeatherUiModel

class WeatherConditionView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val currentTemperatureView: TextView by lazy { findViewById(R.id.weather_information_condition_temperature) }
    private val currentConditionView: TextView by lazy { findViewById(R.id.weather_information_condition_label) }

    init {
        inflate(context, R.layout.view_weather_condition, this)
    }

    fun setWeatherBreakDown(weather: WeatherUiModel) {
        currentTemperatureView.text = weather.temperature
        currentConditionView.text = weather.condition
    }
}
