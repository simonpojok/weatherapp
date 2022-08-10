package me.simonpojok.presentation.usecaseexecutor

import kotlinx.coroutines.CoroutineScope

typealias UseCaseExecutorProvider = @JvmSuppressWildcards (coroutineScope: CoroutineScope) -> Any
