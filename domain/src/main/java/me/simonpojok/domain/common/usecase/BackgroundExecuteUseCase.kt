package me.simonpojok.domain.common.usecase

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.withContext

abstract class BackgroundExecuteUseCase<REQUEST, RESULT> constructor(
    private val coroutineContextProvider: CoroutineContextProvider
) : BaseUseCase<REQUEST, RESULT> {
    final override suspend fun execute(value: REQUEST, callback: (RESULT) -> Unit) {
        val result = withContext(coroutineContextProvider.io) {
            executeInBackground(value, this)
        }

        callback(result)
    }

    abstract suspend fun executeInBackground(
        request: REQUEST,
        coroutineScope: CoroutineScope
    ): RESULT
}
