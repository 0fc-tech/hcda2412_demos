package com.example.mod7apirest

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import com.example.mod7apirest.ui.theme.DemonstrationsTheme
import com.example.mod7apirest.ui.theme.Typography
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    WeatherScreen(Modifier.padding(innerPadding))
                }
            }
        }
    }
}
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun WeatherScreen(modifier: Modifier, viewModel : WeatherViewModel =
                      androidx.lifecycle.viewmodel.compose.viewModel()){
    val weatherData by viewModel.weather.collectAsState(initial = null)

    LazyColumn(modifier) {
        weatherData?.let {
            itemsIndexed(it.time) { index, time ->
                ListItem(
                    headlineContent ={
                        val date = LocalDateTime.parse(time)
                        val formatter = DateTimeFormatter.ofPattern("d MMMM 'à' HH:mm", Locale.FRENCH)
                        Text(text = date.format(formatter)) },
                    trailingContent = {Text(text = "${it.temperature_2m[index]}°C", style =
                        Typography.titleMedium
                    )},
                    modifier = Modifier.fillMaxWidth()
                )
            }
        }
    }
}