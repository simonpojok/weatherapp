package me.simonpojok.data.common.mapper

import me.simonpojok.domain.common.exception.DomainMapperException

class DataMapperException(message: String, throwable: Throwable? = null) :
    Exception(message, throwable)

class DatabaseMapperException(message: String, throwable: Throwable? = null) :
    Exception(message, throwable)

class ApiMapperException(message: String, throwable: Throwable? = null) :
    Exception(message, throwable)

abstract class DomainToDataMapper<INPUT : Any, OUTPUT : Any> {

    fun toData(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw DataMapperException("Could not map ${input::class.simpleName} to Data", throwable)
    }

    protected abstract fun map(input: INPUT): OUTPUT
}

abstract class DataToDomainMapper<INPUT : Any, OUTPUT : Any> {
    fun toDomain(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw DomainMapperException("Could not map ${input::class.simpleName} to Domain", throwable)
    }

    protected abstract fun map(input: INPUT): OUTPUT
}

abstract class DataToDatabaseMapper<INPUT : Any, OUTPUT : Any> {

    fun toDatabase(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw DatabaseMapperException(
            "Could not map ${input::class.simpleName} to Database",
            throwable
        )
    }

    protected abstract fun map(input: INPUT): OUTPUT
}

abstract class DatabaseToDataMapper<INPUT : Any, OUTPUT : Any> {

    fun toData(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw DataMapperException("Could not map ${input::class.simpleName} to Data", throwable)
    }

    protected abstract fun map(input: INPUT): OUTPUT
}

abstract class DataToPersistenceMapper<INPUT : Any, OUTPUT : Any> {

    fun toPersistence(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw DatabaseMapperException(
            "Could not map ${input::class.simpleName} to Persistence",
            throwable
        )
    }

    protected abstract fun map(input: INPUT): OUTPUT
}

abstract class PersistenceToDataMapper<INPUT : Any, OUTPUT : Any> {

    fun toData(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw DataMapperException("Could not map ${input::class.simpleName} to Data", throwable)
    }

    protected abstract fun map(input: INPUT): OUTPUT
}

abstract class DataToApiMapper<INPUT : Any, OUTPUT : Any> {
    fun toApi(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw ApiMapperException("Could not map ${input::class.simpleName} to Api", throwable)
    }

    protected abstract fun map(input: INPUT): OUTPUT
}

abstract class ApiToDataMapper<INPUT : Any, OUTPUT : Any> {
    fun toData(input: INPUT): OUTPUT = try {
        map(input)
    } catch (throwable: Throwable) {
        throw DataMapperException("Could not map ${input::class.simpleName} to Data", throwable)
    }

    protected abstract fun map(input: INPUT): OUTPUT
}
