package com.example.data.datasource

import com.example.domain.model.BootEventDomain

interface BootEventsDataSource {
    interface Local {
        fun saveBootEvent(bootEventDomain: BootEventDomain)
        suspend fun fetchBootEvents(): List<BootEventDomain>
        suspend fun fetchLastTwoBootEvents(): List<BootEventDomain>
    }
}