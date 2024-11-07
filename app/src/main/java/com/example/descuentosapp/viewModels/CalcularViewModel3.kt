package com.example.descuentosapp.viewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.descuentosapp.model.CalcularState

class CalcularViewModel3 : ViewModel() {

    var state by mutableStateOf(CalcularState())
    private set

    fun onValue(text: String, value: String) {
        when (text) {
            "precio" -> state = state.copy(precio = value)
            "descuento" -> state = state.copy(descuento = value)
            "precioDescuento" -> state = state.copy(precioDescuento = value)
            "totalDescuento" -> state = state.copy(totalDescuento = value)
            "showAlert" -> state = state.copy(showAlert = value == "true")
        }
    }

    fun calcular() {
        val precio = state.precio
        val descuento = state.descuento
        if (precio != "" && descuento != "") {
            state = state.copy(precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble()).toString(),
            totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble()).toString())
        } else {
            state = state.copy(showAlert = true)
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
        state = state.copy(
            precio = "",
        descuento = "",
        precioDescuento = "",
        totalDescuento = "")
    }

    fun cancelarAletar() {
        state = state.copy(showAlert = false)
    }
}