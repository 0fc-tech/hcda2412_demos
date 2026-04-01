package com.example.mod3demo2

import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.Badge
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemColors
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.mod3demo2.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Surface() {
                    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                        LazyColumnExample(Modifier.padding(innerPadding))
                    }
                }
            }
        }
    }
}

@Composable
fun RowAndColumn(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text("Recette du gâteau aux pommes")
        Row{
            Icon(Icons.Default.Check, contentDescription = "")
            Text("Prenez un saladier")
        }
        Text("Ajouter les pommes pelées et coupées en lamelles")
    }
}

@Preview
@Composable
private fun RowAndColumnPreview() {
    DemonstrationsTheme{
        RowAndColumn()
    }
}

@Composable
fun BoxNotification(modifier: Modifier = Modifier) {
    Box(contentAlignment = Alignment.BottomEnd) {
        Image(
            painterResource(R.drawable.google),
            contentDescription = ""
        )
        Badge(Modifier.padding(8.dp)) { Text("+99") }
    }
}

@Preview
@Composable
private fun BoxNotificationPreview() {
    DemonstrationsTheme {
        BoxNotification()
    }
}

@Composable
fun SpacerExample(modifier: Modifier = Modifier) {
    Column(modifier.background(Color.Cyan)) {
        Text(text = "La communauté de l'anneau")
        Spacer(Modifier.height(8.dp))
        Text(text = "Les deux tours")
        Spacer(Modifier.height(8.dp))
        Text(text = "Le retour du roi",modifier=Modifier.border(
                border = BorderStroke(1.dp,Color.Red)))
        Spacer(Modifier.height(8.dp)
        )
    }
}

@Preview
@Composable
private fun SpacerExamplePreview() {
    DemonstrationsTheme {
        SpacerExample()
    }
}

@Composable
fun LazyColumnExample(modifier: Modifier = Modifier) {
    val listArticles = List(500){"Article numéro $it"}
    LazyColumn(modifier.fillMaxWidth()) {
        items(listArticles){
            OutlinedCard(modifier=Modifier.padding(8.dp)){
                ListItem(
                    {
                        Text(it)
                    }, leadingContent = {
                        Icon(Icons.Default.PlayArrow, contentDescription = "")
                    },
                    trailingContent = {
                        Image(
                            painterResource(R.drawable.google),
                            contentDescription = "",
                            Modifier.size(48.dp)
                        )
                    },
                    supportingContent = {
                        Text("Sous-titre")
                    },
                    colors = ListItemDefaults.colors(containerColor = Color.Transparent),
                )
            }
        }
    }
}