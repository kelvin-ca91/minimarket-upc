package com.example.minimarket.view

import ProductsRepository
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.R
import com.example.minimarket.adapters.ProductAdapter
import com.example.minimarket.view.custom.CustomToolbar

class ProductsByCategoryActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_by_category)

        val categoryId = intent.getStringExtra("CATEGORY_ID")?.toIntOrNull()?:0
        val category = CategoryRepository.findCategoryById(categoryId)

        // Text toolbar
        val customToolbar = findViewById<CustomToolbar>(R.id.custom_toolbar)
        customToolbar.setTitle(category!!.title)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewProductsByCategory)
        recyclerView.layoutManager = GridLayoutManager(this, 2)

        val products = ProductsRepository.filterProductsByCategory(categoryId)

        val adapter = ProductAdapter(products) { product ->
            val intent = Intent(this, DetailProductActivity::class.java)
            intent.putExtra("PRODUCT_ID", product.id.toString())
            startActivity(intent)
        }
        recyclerView.adapter = adapter
    }
}