package me.simonpojok.weatherapp.weather.widgets

import android.content.Context
import android.util.AttributeSet
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import me.simonpojok.weatherapp.R
import me.simonpojok.weatherapp.weather.model.WeatherBreakDownUiModel

class WeatherBreakDownView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {
    private val minTemperatureView: TextView by lazy { findViewById(R.id.view_weather_break_down_min_temperature) }
    private val currentTemperatureView: TextView by lazy { findViewById(R.id.view_weather_break_down_current_temperature) }
    private val maxTemperatureView: TextView by lazy { findViewById(R.id.view_weather_break_down_max_temperature) }

    init {
        inflate(context, R.layout.view_weather_break_down, this)
    }

    fun setWeatherBreakDown(breakdown: WeatherBreakDownUiModel) {
        if (breakdown is WeatherBreakDownUiModel.Result) {
            minTemperatureView.text = breakdown.minTemperature
            currentTemperatureView.text = breakdown.currentTemperature
            maxTemperatureView.text = breakdown.maxTemperature
        }
    }
}
