package me.simonpojok.presentation.common.internal

import me.simonpojok.presentation.common.exception.DomainException
import me.simonpojok.presentation.common.exception.PresentationException
import me.simonpojok.presentation.common.mappers.DomainToPresentationMapper

class GeneralDomainToPresentationExceptionMapper :
    DomainToPresentationMapper<DomainException, PresentationException>() {
    override fun map(input: DomainException): PresentationException {
        TODO("Not yet implemented")
    }
}
