package com.example.minimarket.view

import android.annotation.SuppressLint
import android.content.Intent
import com.example.minimarket.adapters.CestaAdapter
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.R
import com.example.minimarket.ubicacionPedidoActivity
import com.example.minimarket.view.custom.CustomToolbar

class CestaActivity : AppCompatActivity() {
    private lateinit var customToolbar: CustomToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cesta)

        // Text toolbar
        customToolbar = findViewById(R.id.custom_toolbar)
        customToolbar.setTitle("Mi Cesta")

        val btnRedirect = findViewById<Button>(R.id.btnRedirect)
        btnRedirect.setOnClickListener {
            // Redirigir a la nueva AppCompatActivity
            val intent = Intent(this, ubicacionPedidoActivity::class.java)
            startActivity(intent)
        }

        // Lista de productos
        val items = mutableListOf("Coca cola 600ml", "Inca Kola 600ml")
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val adapter = CestaAdapter(items) { position ->
            items.removeAt(position)
            recyclerView.adapter?.notifyItemRemoved(position)
        }
        recyclerView.adapter = adapter
    }
}