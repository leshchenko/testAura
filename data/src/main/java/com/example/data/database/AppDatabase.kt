package com.example.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.data.database.dao.BootEventsDao
import com.example.data.database.entity.BootEventEntity

@Database(
    version = 1, entities = [BootEventEntity::class]
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun getBootEventsDao(): BootEventsDao

    companion object {
        const val DATABASE_NAME = "app_database.db"
    }
}