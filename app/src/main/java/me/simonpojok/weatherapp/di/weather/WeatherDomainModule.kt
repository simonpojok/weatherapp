package me.simonpojok.weatherapp.di.weather

import dagger.Module
import dagger.Provides
import dagger.Reusable
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import me.simonpojok.domain.common.DispatchersCoroutineContextProvider
import me.simonpojok.domain.common.usecase.CoroutineContextProvider
import me.simonpojok.domain.common.usecase.UseCaseExecutor
import me.simonpojok.presentation.common.usecaseexecutor.UseCaseExecutorProvider

@Module
@InstallIn(SingletonComponent::class)
object WeatherDomainModule {

    @Provides
    @Reusable
    fun provideCoroutineContextProvider(): CoroutineContextProvider =
        DispatchersCoroutineContextProvider()

    @Provides
    @Reusable
    fun providesUseCaseExecutorProvider(): UseCaseExecutorProvider =
        { coroutineScope -> UseCaseExecutor(coroutineScope) }
}
