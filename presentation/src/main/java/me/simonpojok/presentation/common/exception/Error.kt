package me.simonpojok.presentation.common.exception

sealed class Error {
    object None : Error()
    data class Api(val message: String) : Error()
    data class Connection(val message: String) : Error()
    data class UnProcessableEntity(val message: String) : Error()
    data class NotFound(val message: String) : Error()
    data class Other(val message: String) : Error()
}
