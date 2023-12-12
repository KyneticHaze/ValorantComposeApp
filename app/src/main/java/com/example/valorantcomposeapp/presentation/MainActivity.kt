package com.example.valorantcomposeapp.presentation

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresExtension
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.valorantcomposeapp.presentation.ui.theme.ValorantComposeAppTheme
import dagger.hilt.android.AndroidEntryPoint
@RequiresExtension(extension = Build.VERSION_CODES.S, version = 7)
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