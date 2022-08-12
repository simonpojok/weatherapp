package me.simonpojok.weatherapp.weather

import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import me.simonpojok.presentation.common.DialogCommand
import me.simonpojok.presentation.weather.WeatherInformationViewModel
import me.simonpojok.presentation.weather.WeatherInformationViewState
import me.simonpojok.weatherapp.R
import me.simonpojok.weatherapp.common.BaseFragment
import javax.inject.Inject

@AndroidEntryPoint
class WeatherInformationFragment : BaseFragment<WeatherInformationViewState, DialogCommand>() {
    override val layout: Int = R.layout.fragment_weather_information

    @Inject
    override lateinit var destinationMapper: WeatherInformationUiDestinationMapper

    override val viewModel: WeatherInformationViewModel by viewModels()
}
