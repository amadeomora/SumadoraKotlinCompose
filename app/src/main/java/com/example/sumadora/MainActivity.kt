package com.example.sumadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.sumadora.ui.SumadoraApp
import com.example.sumadora.ui.theme.SumadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SumadoraTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    SumadoraApp()
                }
            }
        }
    }
}
