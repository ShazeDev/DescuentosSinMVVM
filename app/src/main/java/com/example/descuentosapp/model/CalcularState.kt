package com.example.descuentosapp.model

data class CalcularState(
    val precio : String = "",
    val descuento: String = "",
    val precioDescuento: String = "",
    val totalDescuento: String = "",
    val showAlert : Boolean = false
)
