package com.example.auratest.receiver

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
import com.example.data.database.AppDatabase
import com.example.data.database.entity.BootEventEntity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import kotlin.concurrent.thread

@AndroidEntryPoint
class BootReceiver : BroadcastReceiver() {
    @Inject
    lateinit var bootEventsUseCase: AppDatabase

    // TODO check why it works not every time
    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == Intent.ACTION_BOOT_COMPLETED) {
            // TODO setup notification channel etc.
            // TODO run work manager 15 minutes work to show notification
            thread {
                bootEventsUseCase.getBootEventsDao().insert(
                        BootEventEntity(id = null, bootTimestamp = System.currentTimeMillis())
                )
            }
        }
    }
}