package me.simonpojok.presentation.common.mappers

class PresentationMapperException(message: String, throwable: Throwable? = null) :
    Exception(message, throwable)

abstract class DomainToPresentationMapper<INPUT : Any, OUTPUT : Any> {

    fun toPresentation(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw PresentationMapperException("Could not map ${input::class.simpleName}", throwable)
    }

    protected abstract fun map(input: INPUT): OUTPUT
}
