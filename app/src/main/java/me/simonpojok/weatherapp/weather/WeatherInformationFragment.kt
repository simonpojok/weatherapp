package me.simonpojok.weatherapp.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import me.simonpojok.presentation.common.DialogCommand
import me.simonpojok.presentation.weather.WeatherInformationViewModel
import me.simonpojok.presentation.weather.WeatherInformationViewState
import me.simonpojok.presentation.weather.model.WeatherPresentationModel
import me.simonpojok.weatherapp.R
import me.simonpojok.weatherapp.common.BaseFragment
import me.simonpojok.weatherapp.weather.mapper.WeatherBreakDownPresentationToUIModelMapper
import me.simonpojok.weatherapp.weather.mapper.WeatherPresentationToUiModelMapper
import me.simonpojok.weatherapp.weather.mapper.WeatherPresentationToWeatherResourceUiModelMapper
import me.simonpojok.weatherapp.weather.model.WeatherResourceUiModel
import javax.inject.Inject

@AndroidEntryPoint
class WeatherInformationFragment : BaseFragment<WeatherInformationViewState, DialogCommand>() {
    override val layout: Int = R.layout.fragment_weather_information

    private val backgroundView: View get() = requireView().findViewById(R.id.weather_information_background)
    private val weatherImageView: ImageView get() = requireView().findViewById(R.id.weather_information_representation_image)

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
    }

    private fun renderBackgroundResources(weather: WeatherPresentationModel) {
        val backgroundResources = weatherPresentationToWeatherResourceUiModelMapper.toUi(weather)
        if (backgroundResources is WeatherResourceUiModel.Result) {
            backgroundView.setBackgroundColor(resources.getColor(backgroundResources.backgroundColor))
            weatherImageView.setImageResource(backgroundResources.headerImage)
        }
    }
}
