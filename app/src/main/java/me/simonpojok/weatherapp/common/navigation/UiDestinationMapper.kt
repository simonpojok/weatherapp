package me.simonpojok.weatherapp.common.navigation

import me.simonpojok.presentation.common.PresentationDestination

interface UiDestinationMapper {
    fun map(presentationDestination: PresentationDestination): UiDestination

    fun throwInvalidDestinationException(currentDestinationClass: PresentationDestination): Nothing =
        throw IllegalArgumentException(
            "Destination ${currentDestinationClass::class.java.name} is not supported. " +
                "Please specify appropriate mapper"
        )
}
