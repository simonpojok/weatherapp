package me.simonpojok.remote.weather.model

data class SystemRemoteModel(
    val type: Int,
    val id: Int,
    val country: String,
    val sunrise: Long,
    val sunset: Long
)
