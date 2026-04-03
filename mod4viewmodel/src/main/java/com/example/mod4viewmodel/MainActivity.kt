package com.example.mod4viewmodel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mod4viewmodel.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    RatingScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RatingScreen(
    modifier: Modifier = Modifier,
    ratingViewModel : RatingViewModel = viewModel()) {
    val currentRating by ratingViewModel.currentRating.collectAsState()
    val ratingState by ratingViewModel.ratingState.collectAsState()
    val userAnswer by ratingViewModel.userAnswer.collectAsState()

    Column(modifier){
        Slider(
            value = currentRating,
            steps = 10,
            valueRange = 0f..10f,
            onValueChange ={
                ratingViewModel.updateRating(it)
            }
        )
        if (!ratingState) {
            Text(text = "Qu'est-ce qu'on pourrait faire de mieux la prochaine fois ?")
            TextField(value = userAnswer, onValueChange = {
                ratingViewModel.updateText(it)
            })
        } else  {
            Text(text = "Nous sommes contents de voir que cela s’est bien passé")
        }
    }
}