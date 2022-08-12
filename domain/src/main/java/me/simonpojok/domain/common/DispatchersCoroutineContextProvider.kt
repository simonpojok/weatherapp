package me.simonpojok.domain.common

import kotlinx.coroutines.Dispatchers
import me.simonpojok.domain.common.usecase.CoroutineContextProvider
import kotlin.coroutines.CoroutineContext

class DispatchersCoroutineContextProvider :
    CoroutineContextProvider {
    override val main: CoroutineContext by lazy { Dispatchers.Main }
    override val io: CoroutineContext by lazy { Dispatchers.IO }
}
