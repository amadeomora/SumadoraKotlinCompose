package com.example.sumadora.ui

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

data class SumadoraUiState(
    val historico: MutableList<String> = mutableListOf()
)

class SumadoraViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(SumadoraUiState())
    val uiState: StateFlow<SumadoraUiState> = _uiState

    fun update(
        suma: String
    ) {
        _uiState.update {
            it.copy(
                historico = it.historico.toMutableList().apply { add(suma) },
            )
        }
    }
}