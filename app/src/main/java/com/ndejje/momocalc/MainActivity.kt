package com.ndejje.momocalc

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import com.ndejje.momocalc.ui.theme.MoMoTopBar
import com.ndejje.momocalc.ui.theme.MoMoAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MoMoAppTheme {         // ← replaces raw MaterialTheme(...)
                Surface(modifier = Modifier.fillMaxSize()) {
                    Scaffold(topBar = { MoMoTopBar() }) { innerPadding ->
                        MoMoCalcScreen(modifier = Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}