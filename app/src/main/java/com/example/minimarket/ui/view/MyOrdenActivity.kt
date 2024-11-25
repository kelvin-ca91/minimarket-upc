package com.example.minimarket.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.minimarket.R
import com.example.minimarket.ui.view.custom.CustomToolbar

class MyOrdenActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var rbDelivery: RadioButton
    private lateinit var mapImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orden)

        val customToolbar = findViewById<CustomToolbar>(R.id.custom_toolbar)
        customToolbar.setTitle("Mi Orden")

        radioGroup = findViewById(R.id.radioGroup)
        rbDelivery = findViewById(R.id.rbDelivery)
        mapImageView = findViewById(R.id.mapImageView)

        // Escuchar cambios en el RadioGroup
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.rbDelivery) {
                // Mostrar el mapa si se selecciona "Delivery"
                mapImageView.visibility = View.VISIBLE
            } else {
                // Ocultar el mapa si se selecciona "Recoger en tienda"
                mapImageView.visibility = View.GONE
            }
        }

        val confirmOrder = findViewById<Button>(R.id.btnConfirmOrder)
        confirmOrder.setOnClickListener {
            val intent = Intent(this, ConfirmacionActivity::class.java)
            startActivity(intent)
        }

    }
}