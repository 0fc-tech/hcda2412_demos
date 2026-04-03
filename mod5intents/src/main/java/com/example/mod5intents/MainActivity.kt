package com.example.mod5intents

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.content.ContextCompat.startActivity
import com.example.mod5intents.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ButtonToTarget(Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ButtonToTarget(modifier: Modifier = Modifier) {
    val context =  LocalContext.current;
    Column{
        Button({
            context.startActivity(
                Intent(context, TargetActivity::class.java)
            )
        }, modifier =modifier) {
            Text("Aller vers l'autre activité")
        }
        Button({
            context.startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    //Uri.parse("geo:47.4728657,-0.5534174?z=21")
                    Uri.parse("tel:3938")
                )
            )
        }, modifier =modifier) {
            Text("Appel assitance")
        }

    }
}
