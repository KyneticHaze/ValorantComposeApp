package com.example.valorantcomposeapp.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import com.example.valorantcomposeapp.presentation.ui.theme.ValorantComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint

@RequiresExtension(
    extension = Build.VERSION_CODES.S,
    version = 7
)
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ValorantComposeAppTheme {
                ValorantApp()
            }
        }
    }
}