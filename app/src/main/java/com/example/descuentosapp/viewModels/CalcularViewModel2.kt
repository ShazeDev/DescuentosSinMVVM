package com.example.descuentosapp.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class CalcularViewModel2 : ViewModel() {
    var precio by mutableStateOf("")
        private set
    var descuento by mutableStateOf("")
        private set
    var precioDescuento by mutableStateOf("")
        private set
    var totalDescuento by mutableStateOf("")
        private set
    var showAlert by mutableStateOf(false)
        private set

    fun onValue(text: String, value: String) {
        when (text) {
            "precio" -> precio = value
            "descuento" -> descuento = value
            "precioDescuento" -> precioDescuento = value
            "totalDescuento" -> totalDescuento = value
            "showAlert" -> showAlert = value == "true"
        }
    }

    fun calcular() {
        if (precio != "" && descuento != "") {
            precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble()).toString()
            totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble()).toString()
        } else {
            showAlert = true
        }
    }

    fun calcularPrecio(precio: Double, descuento: Double): Double {
        val res = precio - calcularDescuento(precio, descuento)
        return kotlin.math.round(res * 100) / 100.0
    }

    fun calcularDescuento(precio: Double, descuento: Double): Double {
        val res = precio * (1 - descuento / 100)
        return kotlin.math.round(res * 100) / 100.0
    }

    fun limpiar() {
        precio = ""
        descuento = ""
        precioDescuento = ""
        totalDescuento = ""
    }

    fun cancelarAletar() {
        showAlert = false
    }
}
