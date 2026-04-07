package com.example.mod5navigation.ui.page

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun HomePage(modifier: Modifier = Modifier, onTargetClick : ()->Unit) {
    Scaffold(
        floatingActionButton = {
            FloatingActionButton({}) {
                Icon(Icons.Filled.Add,contentDescription = "Add")}
        }){ innerPadding->
        Button(onClick = {
            onTargetClick()
        },
            modifier = Modifier.padding(innerPadding)) {
            Text("Go Target")
        }
    }
}