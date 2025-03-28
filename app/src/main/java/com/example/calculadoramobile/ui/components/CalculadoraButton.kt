package com.example.calculadoramobile.ui.components

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp

@Composable
fun CalculadoraButton(
    label: String,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    val isOperator = label in listOf("+", "-", "*", "/", "=")
    val buttonColor = if (isOperator) Color(0xFF6200EA) else Color.Gray

    Button(
        onClick = onClick,
        modifier = modifier.aspectRatio(1f),
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
    ) {
        Text(text = label, fontSize = 24.sp, color = Color.White)
    }
}
