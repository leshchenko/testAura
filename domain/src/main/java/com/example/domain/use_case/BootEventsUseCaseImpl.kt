package com.example.domain.use_case

import com.example.domain.model.BootEventDomain
import com.example.domain.repository.BootEventsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class BootEventsUseCaseImpl(private val bootEventsRepository: BootEventsRepository): BootEventsUseCase {
    override fun saveBootEvent(bootEventDomain: BootEventDomain) {
        bootEventsRepository.saveBootEvent(bootEventDomain)
    }

    override suspend fun fetchBootEvents(): List<BootEventDomain> = withContext(Dispatchers.IO)  {
        bootEventsRepository.fetchBootEvents()
    }

    override suspend fun fetchLastTwoBootEvents(): List<BootEventDomain> = withContext(Dispatchers.IO)  {
        bootEventsRepository.fetchLastTwoBootEvents()
    }

}