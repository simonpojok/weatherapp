package me.simonpojok.remote.common.mapper

import me.simonpojok.remote.common.exception.RemoteMapperException

abstract class DataToRemoteMapper<INPUT : Any, OUTPUT : Any> {
    fun toRemote(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw RemoteMapperException("Could not map ${input::class.simpleName} to Api", throwable)
    }

    protected abstract fun map(input: INPUT): OUTPUT
}
