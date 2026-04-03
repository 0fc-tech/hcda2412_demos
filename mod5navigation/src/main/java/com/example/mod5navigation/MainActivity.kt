package com.example.mod5navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.mod5navigation.ui.page.HomePage
import com.example.mod5navigation.ui.page.TargetPage
import com.example.mod5navigation.ui.theme.DemonstrationsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DemonstrationsTheme {
                ContainerNavigation()
            }
        }
    }
}

@Composable
fun ContainerNavigation(modifier: Modifier = Modifier,
                        controller: NavHostController =rememberNavController() ) {
    NavHost(
        navController = controller,
        startDestination = "home",
    ) {
        composable("home"){ HomePage() {controller.navigate("target") } }
        composable("target"){ TargetPage() }
    }
}