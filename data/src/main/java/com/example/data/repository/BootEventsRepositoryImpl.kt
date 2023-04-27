package com.example.data.repository

import com.example.data.datasource.BootEventsDataSource
import com.example.domain.model.BootEventDomain
import com.example.domain.repository.BootEventsRepository

class BootEventsRepositoryImpl(private val bootEventsLocalDataSource: BootEventsDataSource.Local) :
    BootEventsRepository {
    override fun saveBootEvent(bootEventDomain: BootEventDomain) {
        bootEventsLocalDataSource.saveBootEvent(bootEventDomain)
    }

    override suspend fun fetchBootEvents(): List<BootEventDomain> =
        bootEventsLocalDataSource.fetchBootEvents()

    override suspend fun fetchLastTwoBootEvents(): List<BootEventDomain> =
        bootEventsLocalDataSource.fetchLastTwoBootEvents()
}