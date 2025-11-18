package com.github.EspanholHS.gsimc_victor_e_diogo

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MenuScreen(
    onImcClick: () -> Unit,
    onEquipeClick: () -> Unit,
    onLogoutClick: () -> Unit
) {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(32.dp)
                .fillMaxWidth()
        ) {
            Text(text = "MENU", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = onImcClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Cálculo de IMC")
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onEquipeClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Equipe")
            }
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = onLogoutClick,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Voltar")
            }
        }
    }
}