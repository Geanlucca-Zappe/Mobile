package com.example.calculadoramobile.logic

import android.renderscript.ScriptGroup.Input
import android.view.Display

class CalculadoraLogic {
    private var operador: String? = null
    private var primeiroNumero: String? = null

    fun processInput(input: String, currentDisplay: String): String {
        return when (input) {
            in "0".."9" -> {
                if (currentDisplay == "0") input else currentDisplay + input
            }
            "+", "-", "*", "/" -> {
                operador = input
                primeiroNumero = currentDisplay
                "0"
            }
            "=" -> calcular(currentDisplay)
            "C" -> {
                operador = null
                primeiroNumero = null
                "0"
            }
            else -> currentDisplay
        }
    }

    private fun calcular(segundoNumero: String): String {
        val num1 = primeiroNumero?.toDoubleOrNull() ?: return "Erro"
        val num2 = segundoNumero.toDoubleOrNull() ?: return "Erro"

        val resultado = when (operador) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            "/" -> if (num2 != 0.0) num1 / num2 else return "Erro"
            else -> return "Erro"
        }

        operador = null
        primeiroNumero = null

        return resultado.toString()
    }
}