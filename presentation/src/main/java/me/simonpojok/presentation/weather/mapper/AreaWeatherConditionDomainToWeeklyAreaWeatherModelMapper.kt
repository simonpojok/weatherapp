package me.simonpojok.presentation.weather.mapper

import me.simonpojok.domain.weather.model.AreaWeatherConditionDomainModel
import me.simonpojok.presentation.common.mappers.DomainToPresentationMapper
import me.simonpojok.presentation.weather.model.AreaWeatherConditionPresentationModel
import java.time.LocalDate
import java.time.format.TextStyle
import java.util.Locale

class AreaWeatherConditionDomainToWeeklyAreaWeatherModelMapper(
    private val areaWeatherConditionMapper: AreaWeatherConditionDomainToPresentationModelMapper
) :
    DomainToPresentationMapper<List<AreaWeatherConditionDomainModel>, List<AreaWeatherConditionPresentationModel>>() {
    override fun map(input: List<AreaWeatherConditionDomainModel>) =
        input.map(areaWeatherConditionMapper::toPresentation)
            .map { weatherForecast ->
                weatherForecast.copy(
                    dateTime = weatherForecast.dateTime.dayOfWeek()
                )
            }.distinctBy { weatherForecast -> weatherForecast.dateTime }
            .toList()

    private fun String.dayOfWeek(): String {
        val dateString = this.split(" ").first()
        return LocalDate.parse(dateString).dayOfWeek.getDisplayName(TextStyle.FULL, Locale.CANADA)
    }
}
