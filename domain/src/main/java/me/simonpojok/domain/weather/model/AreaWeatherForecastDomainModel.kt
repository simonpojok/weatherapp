package me.simonpojok.domain.weather.model

data class AreaWeatherForecastDomainModel(
    val forcasts: List<AreaWeatherConditionDomainModel>
)
