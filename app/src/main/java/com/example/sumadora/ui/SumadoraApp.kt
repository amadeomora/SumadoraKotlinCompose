package com.example.sumadora.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sumadora.R

enum class SumadoraScreen {
    SumaScreen,
    HistoricoScreen
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SumadoraApp(
    viewModel: SumadoraViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(R.string.sumadora))
                }
            )
        }
    ) { innerPadding ->

        val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = SumadoraScreen.SumaScreen.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = SumadoraScreen.SumaScreen.name) {
                SumaScreen(
                    viewModel = viewModel,
                    onClickButton = {
                        navController.navigate(SumadoraScreen.HistoricoScreen.name)
                    }
                )
            }

            composable(route = SumadoraScreen.HistoricoScreen.name) {
                HistoricoScreen(
                    sumadoraUiState = uiState,
                    onClickButton = {
                        navController.popBackStack()
                    }
                )
            }
        }
    }
}
