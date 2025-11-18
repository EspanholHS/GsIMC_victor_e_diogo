package com.github.EspanholHS.gsimc_victor_e_diogo

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun ImcScreen(
    onBack: () -> Unit
) {
    var nome by remember { mutableStateOf("") }
    var peso by remember { mutableStateOf("") }
    var altura by remember { mutableStateOf("") }
    var resultado by remember { mutableStateOf<String?>(null) }

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
            Text(text = "Calculadora IMC", style = MaterialTheme.typography.headlineSmall)
            Spacer(modifier = Modifier.height(24.dp))

            OutlinedTextField(
                value = nome,
                onValueChange = { nome = it },
                label = { Text("Seu nome") },
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = peso,
                onValueChange = { it ->
                    peso = it.filter { c -> c.isDigit() || c == '.' }
                },
                label = { Text("Seu Peso (Em kg. Ex: 60.5)") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = altura,
                onValueChange = { it ->
                    altura = it.filter { c -> c.isDigit() || c == '.' }
                },
                label = { Text("Sua altura (Em metros. Ex: 1.80)") },
                modifier = Modifier.fillMaxWidth(),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number)
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    val p = peso.toFloatOrNull()
                    val a = altura.toFloatOrNull()

                    resultado = if (nome.isNotBlank() && p != null && a != null && a > 0f) {
                        val imc = p / (a * a)
                        "${nome}, seu IMC é: %.2f".format(imc)
                    } else {
                        "Preencha todos os campos corretamente."
                    }
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Calcular")
            }
            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = onBack,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Voltar")
            }

            Spacer(modifier = Modifier.height(24.dp))
            resultado?.let {
                Text(text = it, style = MaterialTheme.typography.bodyLarge)
            }
        }
    }
}