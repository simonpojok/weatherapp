package me.simonpojok.presentation.weather

import dagger.hilt.android.lifecycle.HiltViewModel
import me.simonpojok.presentation.common.BaseViewModel
import me.simonpojok.presentation.common.DialogCommand
import me.simonpojok.presentation.common.internal.GeneralDomainToPresentationExceptionMapper
import me.simonpojok.presentation.common.usecaseexecutor.UseCaseExecutorProvider
import javax.inject.Inject

@HiltViewModel
class WeatherInformationViewModel @Inject constructor(
    generalDomainToPresentationExceptionMapper: GeneralDomainToPresentationExceptionMapper,
    useCaseExecutorProvider: UseCaseExecutorProvider
) : BaseViewModel<WeatherInformationViewState, DialogCommand>(
    useCaseExecutorProvider = useCaseExecutorProvider,
    exceptionDomainToPresentationMapper = generalDomainToPresentationExceptionMapper
) {
    override fun initialState() = WeatherInformationViewState()
}
