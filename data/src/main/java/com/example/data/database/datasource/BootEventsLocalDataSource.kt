package com.example.data.database.datasource

import com.example.data.database.dao.BootEventsDao
import com.example.data.database.mapper.mapBootEventToDomain
import com.example.data.database.mapper.mapBootEventToEntity
import com.example.data.datasource.BootEventsDataSource
import com.example.domain.model.BootEventDomain

class BootEventsLocalDataSource(private val bootEventsDao: BootEventsDao) :
    BootEventsDataSource.Local {
    override fun saveBootEvent(bootEventDomain: BootEventDomain) {
        bootEventsDao.insert(mapBootEventToEntity(bootEventDomain))
    }

    override suspend fun fetchBootEvents(): List<BootEventDomain> =
        bootEventsDao.fetchBootEvents().map(::mapBootEventToDomain)

    override suspend fun fetchLastTwoBootEvents(): List<BootEventDomain> =
        bootEventsDao.fetchLastTwoBootEvents().map(::mapBootEventToDomain)
}