package com.example.domain.use_case

import com.example.domain.model.BootEventDomain

interface BootEventsUseCase {
    fun saveBootEvent(bootEventDomain: BootEventDomain)
    suspend fun fetchBootEvents(): List<BootEventDomain>
    suspend fun fetchLastTwoBootEvents(): List<BootEventDomain>
}