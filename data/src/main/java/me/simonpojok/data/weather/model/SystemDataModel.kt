package me.simonpojok.data.weather.model

data class SystemDataModel(
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)
