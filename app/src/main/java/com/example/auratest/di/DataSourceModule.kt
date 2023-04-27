package com.example.auratest.di

import com.example.data.database.dao.BootEventsDao
import com.example.data.database.datasource.BootEventsLocalDataSource
import com.example.data.datasource.BootEventsDataSource
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ActivityComponent::class, ViewModelComponent::class)
@Module
abstract class DataSourceBindModule {
    @Binds
    abstract fun bindBootEventsLocalDataSource(
            bootEventsLocalDataSource: BootEventsLocalDataSource
    ): BootEventsDataSource.Local
}

@InstallIn(ActivityComponent::class, ViewModelComponent::class)
@Module
object DataSourceProvideModule {
    @Provides
    fun provideBootEventsLocalDataSource(bootEventsDao: BootEventsDao) =
        BootEventsLocalDataSource(bootEventsDao)
}