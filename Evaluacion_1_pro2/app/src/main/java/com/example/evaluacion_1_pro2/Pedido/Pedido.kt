package com.example.evaluacion_1_pro2.Pedido

class Pedido(var cantidadPastel: Int = 0, var cantidadCazuela: Int = 0) {
    fun calcularSubtotal(): Double {
        val subtotalPastel = cantidadPastel * 12000
        val subtotalCazuela = cantidadCazuela * 10000
        return (subtotalPastel + subtotalCazuela).toDouble()
    }

    fun calcularPropina(subtotal: Double): Double {
        return subtotal * 0.1
    }
}