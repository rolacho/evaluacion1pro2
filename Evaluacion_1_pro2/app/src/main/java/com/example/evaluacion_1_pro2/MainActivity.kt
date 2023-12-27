package com.example.evaluacion_1_pro2

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Switch
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    private lateinit var etCantidadPastel: EditText
    private lateinit var etCantidadCazuela: EditText
    private lateinit var tvTotal: TextView
    private lateinit var tvPropina: TextView
    private var cantidadPastel = 0
    private var cantidadCazuela = 0
    private lateinit var tvTotalPastel: TextView
    private lateinit var tvTotalCazuela: TextView
    private lateinit var tvComida: TextView

    @SuppressLint("UseSwitchCompatOrMaterialCode")
    private lateinit var switchPropina: Switch

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etCantidadPastel = findViewById(R.id.etCantidadPastel)
        etCantidadCazuela = findViewById(R.id.etCantidadCazuela)
        tvTotal = findViewById(R.id.tvTotal)
        tvPropina = findViewById(R.id.tvPropina)
        tvTotalCazuela = findViewById(R.id.tvTotalCazuela)
        tvTotalPastel = findViewById(R.id.tvTotalPastel)
        tvComida = findViewById(R.id.tvComida)
        switchPropina = findViewById(R.id.switchPropina)


        calcularTotal(switchPropina.isChecked)

        switchPropina.setOnCheckedChangeListener { _, isChecked ->
            calcularTotal(isChecked)
        }

        etCantidadPastel.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                cantidadPastel = etCantidadPastel.text.toString().toIntOrNull() ?: 0
                calcularTotal(switchPropina.isChecked)
            }
        }

        etCantidadCazuela.setOnFocusChangeListener { _, hasFocus ->
            if (!hasFocus) {
                cantidadCazuela = etCantidadCazuela.text.toString().toIntOrNull() ?: 0
                calcularTotal(switchPropina.isChecked)
            }
        }
    }

    private fun calcularSubtotal(): Double {
        val precioPastel = 12000.0
        val precioCazuela = 10000.0
        return cantidadPastel * precioPastel + cantidadCazuela * precioCazuela
    }

    private fun calcularTotal(agregarPropina: Boolean) {
        val subtotal = calcularSubtotal()

        var total = subtotal
        val propina = subtotal * 0.1

        val totalCazuela = cantidadCazuela * 10000.0
        val totalPastel = cantidadPastel * 12000.0

        val totalComida = subtotal

        tvComida.text = String.format("Comida  $%.2f", totalComida)

        tvTotalCazuela.text = String.format("$%.2f", totalCazuela)

        tvTotalPastel.text = String.format("$%.2f", totalPastel)

        tvPropina.text = String.format("Propina  $%.2f", propina)

        if (agregarPropina) {
            total += propina
        }

        tvTotal.text = String.format("TOTAL  $%.2f", total)
    }
}
