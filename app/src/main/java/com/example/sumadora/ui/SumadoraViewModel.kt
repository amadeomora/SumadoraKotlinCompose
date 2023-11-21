package com.example.sumadora.ui

import androidx.lifecycle.ViewModel
import com.example.sumadora.models.SumadoraUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class SumadoraViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SumadoraUiState(mutableListOf()))
    val uiState: StateFlow<SumadoraUiState> = _uiState

    fun update(
        currentSuma: String
    ) {
        _uiState.update {
            it.copy(
                historico = it.historico.toMutableList().apply { add(currentSuma) }
            )
        }
    }
}