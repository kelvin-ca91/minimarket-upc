package com.example.minimarket.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.R
import com.example.minimarket.ui.adapters.CompraAdapter
import com.example.minimarket.data.model.Compra
import com.example.minimarket.data.repository.OrderRepository
import com.example.minimarket.data.repository.ProductoRepository
import com.example.minimarket.ui.adapters.ProductAdapter
import com.example.minimarket.ui.view.custom.CustomToolbar
import com.example.minimarket.utils.ClientManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MisComprasActivity : AppCompatActivity() {
    private lateinit var customToolbar: CustomToolbar
    private val orderRepository = OrderRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ocultar el ActionBar en esta actividad
        supportActionBar?.hide()

        setContentView(R.layout.activity_mis_compras)

        // Text toolbar
        customToolbar = findViewById(R.id.custom_toolbar)
        customToolbar.setTitle("Mis Compras")

        loadHistoryOrders()


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
                    val intent = Intent(this, MisComprasActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }

    }

    private fun loadHistoryOrders(){
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val clientAuth = ClientManager.getClient()
                val listOrders = clientAuth?.let { orderRepository.listarOrders(it.id) }
                withContext(Dispatchers.Main) {
                    val recyclerView =  findViewById<RecyclerView>(R.id.recyclerViewCompras)
                    recyclerView.layoutManager = GridLayoutManager(this@MisComprasActivity,1)
                    val adapter = CompraAdapter(listOrders!!)
                    recyclerView.adapter = adapter
                }

            } catch (e: Exception){
                withContext(Dispatchers.Main) {
                    println(e)
                    Toast.makeText(this@MisComprasActivity, "Ocurrió un error", Toast.LENGTH_SHORT)
                        .show()
                }

            }
        }
    }
}