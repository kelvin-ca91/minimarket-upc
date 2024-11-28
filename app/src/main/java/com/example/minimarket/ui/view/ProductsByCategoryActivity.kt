package com.example.minimarket.ui.view


import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.R
import com.example.minimarket.data.repository.ProductoRepository
import com.example.minimarket.ui.adapters.ProductAdapter
import com.example.minimarket.ui.view.custom.CustomToolbar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ProductsByCategoryActivity : AppCompatActivity() {
    private var categoryId: Int = 0
    private var categoryName: String = ""
    private val productoRepository = ProductoRepository()
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_by_category)

        categoryId = intent.getStringExtra("CATEGORY_ID")?.toIntOrNull()?:0
        categoryName = intent.getStringExtra("CATEGORY_NAME")?:""

        // Text toolbar
        val customToolbar = findViewById<CustomToolbar>(R.id.custom_toolbar)
        customToolbar.setTitle(categoryName)

        loadProduct()
    }

    private fun loadProduct (){
        CoroutineScope(Dispatchers.IO).launch {
            try {

                val listProductsResp = productoRepository.listProductosByCategoria(categoryId)
                withContext(Dispatchers.Main) {
                    val recyclerView =   findViewById<RecyclerView>(R.id.recyclerViewProductsByCategory)
                    recyclerView.layoutManager = GridLayoutManager(this@ProductsByCategoryActivity, 2)

                    val adapter = ProductAdapter(listProductsResp) { product ->
                        val intent = Intent(this@ProductsByCategoryActivity, DetailProductActivity::class.java)
                        intent.putExtra("PRODUCT_ID", product.idproducto.toString())
                        intent.putExtra("PRODUCT_NAME", product.nombre)
                        intent.putExtra("PRODUCT_PRICE", product.precio)
                        intent.putExtra("PRODUCT_IMAGE", product.imagen)
                        startActivity(intent)
                    }
                    recyclerView.adapter = adapter
                }
            } catch (e : Exception){
                withContext(Dispatchers.Main) {
                    println(e)
                    Toast.makeText(this@ProductsByCategoryActivity, "Ocurrió un error", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    }
}