package me.simonpojok.weatherapp.weather.widgets

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import me.simonpojok.weatherapp.R
import me.simonpojok.weatherapp.common.ItemsListAdapter.ViewHolder
import me.simonpojok.weatherapp.weather.model.DailyWeatherForecastUiModel

class DailyWeatherForecastViewHolder(
    itemView: View
) : ViewHolder<DailyWeatherForecastUiModel>(itemView) {
    private val dayView: TextView by lazy { itemView.findViewById(R.id.view_daily_weather_forecast_day) }
    private val temperatureView: TextView by lazy { itemView.findViewById(R.id.view_daily_weather_forecast_temperature) }
    private val weatherIconView: ImageView by lazy { itemView.findViewById(R.id.view_daily_weather_forecast_icon) }

    override fun bind(item: DailyWeatherForecastUiModel) {
        weatherIconView.setImageResource(item.conditionImage)
        temperatureView.text = item.temperature
        dayView.text = item.dayOfWeek
    }
}
