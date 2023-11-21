package com.example.sumadora.ui

import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import com.example.sumadora.R

@Composable
fun SumaScreen(
    viewModel: SumadoraViewModel = viewModel(),
    onClickButton: (String) -> Unit = {}
) {
    var input1 by rememberSaveable  { mutableStateOf("") }
    var input2 by rememberSaveable  { mutableStateOf("") }

    Column(
        modifier = Modifier.verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        EditNumberField(
            label = R.string.primer_numero,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = input1,
            onValueChanged = { input1 = it }
        )

        EditNumberField(
            label = R.string.segundo_numero,
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            value = input2,
            onValueChanged = { input2 = it }
        )

        Button(
            onClick = {
                val mensajeSuma = mensajeSuma(input1, input2)
                viewModel.update(mensajeSuma)
                onClickButton(mensajeSuma)

                input1 = ""
                input2 = ""
            }
        ) {
            Text(
                text = stringResource(R.string.sumar)
            )
        }
    }
}

fun mensajeSuma(input1: String, input2: String): String {
    val numero1 = input1.toDoubleOrNull() ?: 0.0
    val numero2 = input2.toDoubleOrNull() ?: 0.0
    val suma = numero1 + numero2
    return "$numero1 + $numero2 = $suma"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditNumberField(
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    value: String,
    onValueChanged: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = value,
        singleLine = true,
        modifier = modifier,
        onValueChange = onValueChanged,
        label = { Text(stringResource(label)) },
        keyboardOptions = keyboardOptions
    )
}

@Preview
@Composable
fun StartScreenPreview() {
    SumaScreen()
}