package com.example.minimarket.ui.view

import android.content.Intent
import com.example.minimarket.ui.adapters.CestaAdapter
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.R
import com.example.minimarket.databinding.ActivityUbicacionPedidoBinding
import com.example.minimarket.ui.view.custom.CustomToolbar

class CestaActivity : AppCompatActivity() {
    private lateinit var customToolbar: CustomToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cesta)

        // Text toolbar
        customToolbar = findViewById(R.id.custom_toolbar)
        customToolbar.setTitle("Mi Cesta")


        // Lista de productos
        val items = mutableListOf("Coca cola 600ml")
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = CestaAdapter(items) { position ->
            items.removeAt(position)
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