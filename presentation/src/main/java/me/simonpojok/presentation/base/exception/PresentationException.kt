package me.simonpojok.presentation.base.exception

abstract class PresentationException(val throwable: Throwable = Throwable()) : Exception(throwable)
