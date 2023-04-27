package com.example.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.data.database.entity.BootEventEntity

@Dao
abstract class BootEventsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insert(bootEventEntity: BootEventEntity)

    @Query("SELECT * FROM boot_events")
    abstract suspend fun fetchBootEvents(): List<BootEventEntity>

    @Query("SELECT * FROM boot_events ORDER BY bootTimestamp DESC LIMIT 2")
    abstract suspend fun fetchLastTwoBootEvents(): List<BootEventEntity>
}