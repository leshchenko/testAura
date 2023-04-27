package com.example.data.database.mapper

import com.example.data.database.entity.BootEventEntity
import com.example.domain.model.BootEventDomain

fun mapBootEventToDomain(bootEventEntity: BootEventEntity) = with(bootEventEntity) {
    BootEventDomain(id, bootTimestamp)
}

fun mapBootEventToEntity(bootEventDomain: BootEventDomain) = with(bootEventDomain) {
    BootEventEntity(id, bootTimestamp)
}