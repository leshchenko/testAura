package com.example.auratest.di

import com.example.domain.repository.BootEventsRepository
import com.example.domain.use_case.BootEventsUseCase
import com.example.domain.use_case.BootEventsUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.components.SingletonComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class UseCaseBindModule {
    @Binds
    abstract fun bindBootEventsUseCase(
            bootEventsUseCaseImpl: BootEventsUseCaseImpl
    ): BootEventsUseCase
}

@InstallIn(ViewModelComponent::class)
@Module
object UseCaseProvideModule {
    @Provides
    fun provideBootEventsUseCase(bootEventsRepository: BootEventsRepository) =
        BootEventsUseCaseImpl(bootEventsRepository)
}