package me.simonpojok.presentation.base.exception

abstract class DomainException(open val throwable: Throwable) : Exception(throwable) {
    constructor(message: String) : this(Exception(message))
}
