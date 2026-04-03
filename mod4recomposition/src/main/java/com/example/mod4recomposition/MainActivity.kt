package com.example.mod4recomposition

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mod4recomposition.ui.theme.DemonstrationsTheme

private const val TAG = "MainActivity"

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    //RecetteGateauChocolat(modifier = Modifier.padding(innerPadding))
                    Formulaire(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun RecetteGateauChocolat(modifier: Modifier = Modifier) {
    var nbOeufs by remember { mutableIntStateOf(3) }
    Row(modifier) {
        Text("Ingrédients:")
        Spacer(Modifier.weight(1f))
        Column {
            Text("200g de farine")
            Text("100g de sucre")
            Text("100g de beurre")
            Row {
                IconButton({
                    nbOeufs--
                    Log.i(TAG, "RecetteGateauChocolat: $nbOeufs")
                }) {
                    Icon(
                        Icons.Default.KeyboardArrowDown,
                        contentDescription = ""
                    )
                }
                Text("$nbOeufs Oeufs")
                IconButton({
                    nbOeufs++
                    Log.i(TAG, "RecetteGateauChocolat: $nbOeufs")
                }) {
                    Icon(
                        Icons.Default.KeyboardArrowUp,
                        contentDescription = ""
                    )
                }
            }
            Text("100g de chocolat")
        }
        Spacer(Modifier.weight(1f))
    }
}

@Composable
fun Formulaire(modifier: Modifier = Modifier) {
    var prenom by remember { mutableStateOf("") }
    var nom by remember { mutableStateOf("") }
    var dateNaissance by rememberSaveable { mutableStateOf("") }
    Column(modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TextField(
            value = prenom,
            onValueChange = { prenom = it },
            label = { Text("Prénom") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = nom,
            onValueChange = { nom = it },
            label = { Text("Nom") },
            modifier = Modifier.fillMaxWidth()
        )
        TextField(
            value = dateNaissance,
            onValueChange = { dateNaissance = it },
            label = { Text("Date de Naissance") },
            modifier = Modifier.fillMaxWidth()
        )
        Row(
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier.fillMaxWidth()
        ) {
            OutlinedButton(onClick = { /*TODO*/ }) {
                Text("Valider")
            }
            Button(onClick = { /*TODO*/ }) {
                Text(text = "Annuler")
            }
        }
    }
}
