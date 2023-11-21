package com.example.sumadora.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.sumadora.R
import com.example.sumadora.models.SumadoraUiState

@Composable
fun HistoricoScreen(
    sumadoraUiState: SumadoraUiState,
    onBackClick: () -> Unit = {}
) {
    val ultimoIndice = sumadoraUiState.historico.size - 1
    val ultimaSuma = sumadoraUiState.historico[ultimoIndice] ?: ""

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.ultima_suma),
        )

        Box() {
            Text(
                text = ultimaSuma
            )
        }

        Text(
            text = stringResource(R.string.historico_de_sumas),
        )

        Box() {
            Column(
            ) {
                for (suma: String in sumadoraUiState.historico) {
                    Text(
                        text = suma
                    )
                }
            }
        }

        Row() {
            Button(
                onClick = { onBackClick() },
            ) {
                Text(stringResource(R.string.volver_atras))
            }
        }
    }
}

@Preview
@Composable
fun SummaryScreenPreview() {
    HistoricoScreen(
        sumadoraUiState = SumadoraUiState(
            historico = mutableListOf(
                "1 + 2 = 3",
                "2 + 3 = 5",
                "3 + 4 = 7"
            )
        )
    )
}