package me.simonpojok.domain.common.usecase

import me.simonpojok.domain.common.model.DomainException
import me.simonpojok.domain.common.model.UnknownDomainException

interface BaseUseCase<REQUEST, RESULT> {
    suspend fun execute(value: REQUEST, callback: (RESULT) -> Unit)

    fun onError(throwable: Throwable): DomainException = UnknownDomainException(throwable)
}
