package me.simonpojok.domain.weather.model

data class SystemDomainModel(
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)
