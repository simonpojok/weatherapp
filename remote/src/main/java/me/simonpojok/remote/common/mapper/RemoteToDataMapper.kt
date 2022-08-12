package me.simonpojok.remote.common.mapper

import me.simonpojok.data.common.mapper.DataMapperException

abstract class RemoteToDataMapper<INPUT : Any, OUTPUT : Any> {
    fun toData(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw DataMapperException("Could not map ${input::class.simpleName} to Data", throwable)
    }

    protected abstract fun map(input: INPUT): OUTPUT
}
