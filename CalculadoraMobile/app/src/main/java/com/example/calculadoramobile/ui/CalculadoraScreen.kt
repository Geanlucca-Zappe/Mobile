package com.example.calculadoramobile.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.*
import com.example.calculadoramobile.logic.CalculadoraLogic
import com.example.calculadoramobile.ui.components.CalculadoraButton

@Composable
fun CalculadoraScreen() {
    var display by remember { mutableStateOf("0") }
    val logic = remember { CalculadoraLogic() }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.DarkGray)
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        // Display
        Text(
            text = display,
            color = Color.White,
            fontSize = 48.sp,
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            textAlign = TextAlign.End
        )

        // Botões
        val buttons = listOf(
            listOf("7", "8", "9", "/"),
            listOf("4", "5", "6", "*"),
            listOf("1", "2", "3", "-"),
            listOf("C", "0", "=", "+")
        )

        buttons.forEach { row ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 4.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                row.forEach { label ->
                    CalculadoraButton(
                        label = label,
                        modifier = Modifier.weight(1f)
                    ) {
                        display = logic.processInput(label, display)
                    }
                }
            }
        }
    }
}