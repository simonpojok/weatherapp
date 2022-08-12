package me.simonpojok.weatherapp.weather

import android.view.View
import android.widget.ImageView
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import me.simonpojok.presentation.common.DialogCommand
import me.simonpojok.presentation.weather.WeatherInformationViewModel
import me.simonpojok.presentation.weather.WeatherInformationViewState
import me.simonpojok.presentation.weather.model.WeatherBreakDownPresentationModel
import me.simonpojok.presentation.weather.model.WeatherPresentationModel
import me.simonpojok.weatherapp.R
import me.simonpojok.weatherapp.common.BaseFragment
import me.simonpojok.weatherapp.weather.mapper.WeatherBreakDownPresentationToUIModelMapper
import me.simonpojok.weatherapp.weather.mapper.WeatherPresentationToUiModelMapper
import me.simonpojok.weatherapp.weather.mapper.WeatherPresentationToWeatherResourceUiModelMapper
import me.simonpojok.weatherapp.weather.model.WeatherResourceUiModel
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

    @Inject
    override lateinit var destinationMapper: WeatherInformationUiDestinationMapper

    override val viewModel: WeatherInformationViewModel by viewModels()

    @Inject
    lateinit var weatherBreakDownPresentationToUIModelMapper: WeatherBreakDownPresentationToUIModelMapper

    @Inject
    lateinit var weatherPresentationToWeatherResourceUiModelMapper: WeatherPresentationToWeatherResourceUiModelMapper

    @Inject
    lateinit var weatherPresentationToUiModelMapper: WeatherPresentationToUiModelMapper

    override fun renderViewState(viewState: WeatherInformationViewState) {
        super.renderViewState(viewState)


        renderBackgroundResources(viewState.weather)
        renderWeatherStatisics(viewState.weather)
        renderWeatherBreakdown(viewState.weatherBreakDown)
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
