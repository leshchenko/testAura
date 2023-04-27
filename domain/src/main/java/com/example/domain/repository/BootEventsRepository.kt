package com.example.domain.repository

import com.example.domain.model.BootEventDomain

interface BootEventsRepository {
    fun saveBootEvent(bootEventDomain: BootEventDomain)
    suspend fun fetchBootEvents(): List<BootEventDomain>
    suspend fun fetchLastTwoBootEvents(): List<BootEventDomain>
}