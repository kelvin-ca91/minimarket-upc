package com.example.minimarket.ui.view

import android.content.Intent
import com.example.minimarket.ui.adapters.CestaAdapter
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.R
import com.example.minimarket.databinding.ActivityUbicacionPedidoBinding
import com.example.minimarket.ui.view.custom.CustomToolbar
import com.example.minimarket.utils.ProductManager

class CestaActivity : AppCompatActivity() {
    private lateinit var customToolbar: CustomToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cesta)

        // Text toolbar
        customToolbar = findViewById(R.id.custom_toolbar)
        customToolbar.setTitle("Mi Cesta")

        val totalPriceView = findViewById<TextView>(R.id.totalPrice)

        // Lista de productos
        val listProducts = ProductManager.getProducts()

        val totalPrice = listProducts.sumOf { it.price.toDouble() * it.cant.toInt() }
        totalPriceView.setText("S/ "+ totalPrice)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = CestaAdapter(listProducts) { position ->
//            listProducts .removeAt(position)
            recyclerView.adapter?.notifyItemRemoved(position)
        }
        recyclerView.adapter = adapter


        // Button procesar orden
        val btnProcesarOrden = findViewById<Button>(R.id.btnProcesarOrden)
        btnProcesarOrden.setOnClickListener {
            val intent = Intent(this, MyOrdenActivity::class.java)
            startActivity(intent)
        }
    }
}