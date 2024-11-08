package com.example.minimarket.view

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.appcompat.app.AppCompatActivity
import com.example.minimarket.R

class ubicacionPedidoActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var rbDelivery: RadioButton
    private lateinit var mapImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ubicacion_pedido)

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
    }


}