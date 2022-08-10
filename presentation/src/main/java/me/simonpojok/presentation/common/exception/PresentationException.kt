package me.simonpojok.presentation.common.exception

abstract class PresentationException(val throwable: Throwable = Throwable()) : Exception(throwable)
