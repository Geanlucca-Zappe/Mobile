package com.example.calculadoramobile

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

import com.example.calculadoramobile.ui.CalculadoraScreen

class MainActivity : ComponentActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent{
            CalculadoraScreen()
        }
    }
}