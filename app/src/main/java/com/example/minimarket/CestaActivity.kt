package com.example.minimarket

import com.example.minimarket.adapters.CestaAdapter
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

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