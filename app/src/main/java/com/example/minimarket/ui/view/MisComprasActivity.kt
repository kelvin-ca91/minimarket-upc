package com.example.minimarket.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.R
import com.example.minimarket.ui.adapters.CompraAdapter
import com.example.minimarket.data.model.Compra
import com.example.minimarket.ui.view.custom.CustomToolbar
import com.google.android.material.bottomnavigation.BottomNavigationView

class MisComprasActivity : AppCompatActivity() {
    private lateinit var customToolbar: CustomToolbar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ocultar el ActionBar en esta actividad
        supportActionBar?.hide()

        setContentView(R.layout.activity_mis_compras)

        // Text toolbar
        customToolbar = findViewById(R.id.custom_toolbar)
        customToolbar.setTitle("Mis Compras")

        // 1. Obtener una referencia al RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCompras)

        // 2. Configurar el LayoutManager para el RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)

        // 3. Crear una lista de compras de ejemplo
        val compras = listOf(
            Compra("0000123", "Delivery", "10/10/2024", "S/ 15.00", "Pendiente de atención"),
            Compra("0000110", "Recogo en tienda", "08/10/2024", "S/ 82.30", "Entregado"),
            Compra("0000092", "Delivery", "04/10/2024", "S/ 125.20", "Entregado")
        )

        // 4. Crear una instancia de CompraAdapter con la lista de compras
        val adapter = CompraAdapter(compras)

        // 5. Asignar el adaptador al RecyclerView
        recyclerView.adapter = adapter


        // Configurar la barra de navegación inferior
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.inflateMenu(R.menu.bottom_nav_menu)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_categorias -> {
                    // Acción para la opción Categorías
                    val intent = Intent(this, CategoryActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_cesta -> {
                    // Acción para la opción Mi cesta
                    val intent = Intent(this, CestaActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_compras -> {
                    // Acción para la opción Mis compras
                    Toast.makeText(this, "Compras seleccionadas", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> false
            }
        }



    }
}