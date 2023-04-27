package com.example.auratest.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.use_case.BootEventsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(bootEventsUseCase: BootEventsUseCase) : ViewModel() {
    val uiState = MutableStateFlow<UIState>(UIState.Loading)

    init {
        viewModelScope.launch {
            val bootEvents = bootEventsUseCase.fetchBootEvents()
            if (bootEvents.isEmpty()) {
                uiState.tryEmit(UIState.NoBootEvents)
            } else {
                val bootsData = bootEvents.joinToString("\n") { "${it.id} - ${it.bootTimestamp}" }
                uiState.tryEmit(UIState.DisplayBootEventsData(bootsData))
            }
        }
    }

    sealed class UIState {
        object Loading : UIState()
        object NoBootEvents : UIState()
        data class DisplayBootEventsData(val eventsData: String) : UIState()
    }
}