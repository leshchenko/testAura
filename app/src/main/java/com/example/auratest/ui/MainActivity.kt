package com.example.auratest.ui

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.viewModels
import androidx.core.content.ContextCompat
import androidx.core.view.isVisible
import com.example.auratest.R
import com.example.auratest.ext.observeWithLifecycle
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModels()

    private val notificationPermissionLauncher =
        registerForActivityResult(ActivityResultContracts.RequestPermission()) { isGranted ->
            if (!isGranted) {
               // TODO ask user for permission in dialog
            }
        }
    private var progressBar: ProgressBar? = null
    private var dataTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkNotificationPermission()
        progressBar = findViewById(R.id.progressBar)
        dataTextView = findViewById(R.id.dataTextView)

        observeUIState()
    }

    private fun checkNotificationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            when {
                ContextCompat.checkSelfPermission(
                        this,
                        Manifest.permission.POST_NOTIFICATIONS
                ) == PackageManager.PERMISSION_GRANTED -> {
                    // everything is fine
                }
                shouldShowRequestPermissionRationale(Manifest.permission.POST_NOTIFICATIONS) -> {
                    // In an educational UI, explain to the user why your app requires this
                    // permission for a specific feature to behave as expected, and what
                    // features are disabled if it's declined. In this UI, include a
                    // "cancel" or "no thanks" button that lets the user continue
                    // using your app without granting the permission.
    //                showInContextUI(...)
                }
                else -> {
                    // You can directly ask for the permission.
                    // The registered ActivityResultCallback gets the result of this request.
                    notificationPermissionLauncher.launch(
                            Manifest.permission.POST_NOTIFICATIONS
                    )
                }
            }
        }
    }

    private fun observeUIState() {
        mainViewModel.uiState.observeWithLifecycle(this) {
            when (it) {
                is MainViewModel.UIState.DisplayBootEventsData -> {
                    progressBar?.isVisible = false
                    dataTextView?.apply {
                        isVisible = true
                        text = it.eventsData
                    }
                }
                MainViewModel.UIState.Loading -> {
                    progressBar?.isVisible = true
                    dataTextView?.isVisible = false
                }
                MainViewModel.UIState.NoBootEvents -> {
                    progressBar?.isVisible = false
                    dataTextView?.apply {
                        isVisible = true
                        setText(R.string.no_boots_detected)
                    }
                }
            }
        }
    }
}