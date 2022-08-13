package me.simonpojok.weatherapp.weather.mapper

import me.simonpojok.weatherapp.common.mapper.PresentationToUiMapper

class FahrenheitToCelsiusMapper : PresentationToUiMapper<Double, Double>() {
    override fun map(input: Double) = ((input - 32) * 5) / 9
}
