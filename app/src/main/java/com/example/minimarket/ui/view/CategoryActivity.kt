package com.example.minimarket.ui.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.R
import com.example.minimarket.data.repository.CategoriaRepository
import com.example.minimarket.ui.adapters.CategoryAdapter
import com.example.minimarket.ui.view.custom.CustomToolbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CategoryActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private val categoryRepository = CategoriaRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        // Text toolbar
        val customToolbar = findViewById<CustomToolbar>(R.id.custom_toolbar)
        customToolbar.setTitle("Categorías")

        recyclerView = findViewById(R.id.recyclerViewCategories)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        loadCategories()

    }

    private fun loadCategories() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val listCategoryResp = categoryRepository.listCategories()
                println("BEBIDAS")
                println(listCategoryResp)
                withContext(Dispatchers.Main) {
                    if (listCategoryResp.isNotEmpty()) {
                        val adapter = CategoryAdapter(listCategoryResp) { category ->
                            val intent = Intent(this@CategoryActivity, ProductsByCategoryActivity::class.java)
                            intent.putExtra("CATEGORY_ID", category.idcategoria.toString())
                            intent.putExtra("CATEGORY_NAME", category.nombre)
                            startActivity(intent)
                        }
                        recyclerView.adapter = adapter
                    } else {
                        Toast.makeText(this@CategoryActivity, "No hay categorías disponibles", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    Log.e("LoginActivity", "Error: ${e.message}")
                    Toast.makeText(this@CategoryActivity, "Ocurrió un error", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}