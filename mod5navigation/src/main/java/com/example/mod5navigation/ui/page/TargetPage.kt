package com.example.mod5navigation.ui.page

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun TargetPage(modifier: Modifier = Modifier) {
    Scaffold{innerPadding->
        Text("Je suis Target",modifier = Modifier.padding(innerPadding))
    }
}