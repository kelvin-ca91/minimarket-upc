package com.example.minimarket.view

import CategoryRepository
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.R
import com.example.minimarket.adapters.CategoryAdapter
import com.example.minimarket.view.custom.CustomToolbar

class CategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_category)

        // Text toolbar
        val customToolbar = findViewById<CustomToolbar>(R.id.custom_toolbar)
        customToolbar.setTitle("Categorías")

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewCategories)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val categories = CategoryRepository.getCategories()

        val adapter = CategoryAdapter(categories) { category ->
            val intent = Intent(this, ProductsByCategoryActivity::class.java)
            intent.putExtra("CATEGORY_ID", category.id.toString())
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}