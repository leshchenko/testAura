package com.example.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "boot_events")
data class BootEventEntity(
        @PrimaryKey(autoGenerate = true)
        val id: Int?,
        val bootTimestamp: Long
)