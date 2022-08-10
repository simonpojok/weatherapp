package me.simonpojok.presentation.common.usecaseexecutor

import kotlinx.coroutines.CoroutineScope
import me.simonpojok.domain.common.usecase.UseCaseExecutor

typealias UseCaseExecutorProvider = @JvmSuppressWildcards (coroutineScope: CoroutineScope) -> UseCaseExecutor
