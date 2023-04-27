package com.example.auratest.di

import com.example.data.datasource.BootEventsDataSource
import com.example.data.repository.BootEventsRepositoryImpl
import com.example.domain.repository.BootEventsRepository
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class RepositoryBindModule {
    @Binds
    abstract fun bindBootEventsRepository(
            bootEventsRepositoryImpl: BootEventsRepositoryImpl
    ): BootEventsRepository

}

@InstallIn(ViewModelComponent::class)
@Module
object RepositoryProvideModule {
    @Provides
    fun provideBootEventsRepository(
            bootEventsLocalDataSource: BootEventsDataSource.Local,
    ) = BootEventsRepositoryImpl(bootEventsLocalDataSource)
}