package me.simonpojok.weatherapp.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.annotation.LayoutRes
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import dagger.hilt.android.AndroidEntryPoint
import me.simonpojok.presentation.common.DialogCommand
import me.simonpojok.presentation.weather.WeatherInformationViewModel
import me.simonpojok.presentation.weather.WeatherInformationViewState
import me.simonpojok.presentation.weather.model.WeatherBreakDownPresentationModel
import me.simonpojok.presentation.weather.model.WeatherPresentationModel
import me.simonpojok.weatherapp.R
import me.simonpojok.weatherapp.common.BaseFragment
import me.simonpojok.weatherapp.common.ItemsListAdapter
import me.simonpojok.weatherapp.weather.mapper.AreaWeatherConditionPresentationToDailyWeatherForecastUiModelMapper
import me.simonpojok.weatherapp.weather.mapper.WeatherBreakDownPresentationToUIModelMapper
import me.simonpojok.weatherapp.weather.mapper.WeatherPresentationToUiModelMapper
import me.simonpojok.weatherapp.weather.mapper.WeatherPresentationToWeatherResourceUiModelMapper
import me.simonpojok.weatherapp.weather.model.WeatherResourceUiModel
import me.simonpojok.weatherapp.weather.widgets.DailyWeatherForecastViewHolder
import me.simonpojok.weatherapp.weather.widgets.WeatherBreakDownView
import me.simonpojok.weatherapp.weather.widgets.WeatherConditionView
import javax.inject.Inject

@AndroidEntryPoint
class WeatherInformationFragment : BaseFragment<WeatherInformationViewState, DialogCommand>() {
    override val layout: Int = R.layout.fragment_weather_information

    private val backgroundView: View get() = requireView().findViewById(R.id.weather_information_background)
    private val weatherImageView: ImageView get() = requireView().findViewById(R.id.weather_information_representation_image)
    private val weatherConditionView: WeatherConditionView get() = requireView().findViewById(R.id.weather_information_condition)
    private val weatherBreakDownView: WeatherBreakDownView get() = requireView().findViewById(R.id.weather_information_break_down_statistics)
    private val forecastRecyclerView: RecyclerView get() = requireView().findViewById(R.id.weather_information_weekly_statistics_list)

    @Inject
    override lateinit var destinationMapper: WeatherInformationUiDestinationMapper

    override val viewModel: WeatherInformationViewModel by viewModels()

    @Inject
    lateinit var weatherBreakDownPresentationToUIModelMapper: WeatherBreakDownPresentationToUIModelMapper

    @Inject
    lateinit var weatherPresentationToWeatherResourceUiModelMapper: WeatherPresentationToWeatherResourceUiModelMapper

    @Inject
    lateinit var weatherPresentationToUiModelMapper: WeatherPresentationToUiModelMapper

    @Inject
    lateinit var dailyWeatherForecastUiModelMapper: AreaWeatherConditionPresentationToDailyWeatherForecastUiModelMapper

    private val forcastAdapter = ItemsListAdapter { parent, _ ->
        DailyWeatherForecastViewHolder(
            itemView = LayoutInflater.from(requireContext())
                .inflate(R.layout.view_daily_weather_forcast_item, parent, false)
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forecastRecyclerView.adapter = forcastAdapter
    }

    override fun renderViewState(viewState: WeatherInformationViewState) {
        super.renderViewState(viewState)


        renderBackgroundResources(viewState.weather)
        renderWeatherStatisics(viewState.weather)
        renderWeatherBreakdown(viewState.weatherBreakDown)

        forcastAdapter.setAdapterItems(viewState.forcasts.map(dailyWeatherForecastUiModelMapper::toUi))
    }

    private fun renderWeatherBreakdown(weatherBreakDown: WeatherBreakDownPresentationModel) {
        val weatherBreakDownUi = weatherBreakDownPresentationToUIModelMapper.toUi(weatherBreakDown)
        weatherBreakDownView.setWeatherBreakDown(weatherBreakDownUi)
    }

    private fun renderWeatherStatisics(weather: WeatherPresentationModel) {
        val statistics = weatherPresentationToUiModelMapper.toUi(weather)
        weatherConditionView.setWeatherBreakDown(statistics)
    }

    private fun renderBackgroundResources(weather: WeatherPresentationModel) {
        val backgroundResources = weatherPresentationToWeatherResourceUiModelMapper.toUi(weather)
        if (backgroundResources is WeatherResourceUiModel.Result) {
            backgroundView.setBackgroundColor(resources.getColor(backgroundResources.backgroundColor))
            weatherImageView.setImageResource(backgroundResources.headerImage)
        }
    }
}
