package com.github.EspanholHS.gsimc_victor_e_diogo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import androidx.compose.runtime.*
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.github.EspanholHS.gsimc_victor_e_diogo.ui.theme.GsIMC_victor_e_diogoTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GsIMC_victor_e_diogoTheme {
                AppNavHost()
            }
        }
    }
}

@Composable
fun AppNavHost() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "login") {
        composable("login") {
            LoginScreen(
                onLoginSuccess = { navController.navigate("menu") }
            )
        }
        composable("menu") {
            MenuScreen(
                onImcClick = { navController.navigate("imc") },
                onEquipeClick = { navController.navigate("equipe") },
                onLogoutClick = { navController.popBackStack("login", inclusive = false) }
            )
        }
        composable("imc") {
            ImcScreen(
                onBack = { navController.popBackStack() }
            )
        }
        composable("equipe") {
            EquipeScreen(
                integrantes = listOf("Diogo Makoto RM 98446", "Victor Espanhol RM 552532"),
                onBack = { navController.popBackStack() }
            )
        }
    }
}