package com.example.minimarket.view
import ProductsRepository
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.minimarket.R
import com.example.minimarket.view.custom.CustomToolbar

class DetailProductActivity : AppCompatActivity() {
    private lateinit var labelCant:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        val productId = intent.getStringExtra("PRODUCT_ID")?.toIntOrNull()?:0
        val product = ProductsRepository.findProductById(productId)

        val titleProduct = findViewById<TextView>(R.id.titleProduct)
        titleProduct.text = product?.title

        val priceProduct = findViewById<TextView>(R.id.priceProduct)
        priceProduct.text = "S/ "+product?.price.toString()

        val imageProduct = findViewById<ImageView>(R.id.imageProduct)
        imageProduct.setImageResource(product!!.imageResId)


        // Text toolbar
        val customToolbar = findViewById<CustomToolbar>(R.id.custom_toolbar)
        customToolbar.setTitle(product.title)

        // buttons add cants
        val btnAddMore = findViewById<Button>(R.id.btnAddMore)
        val btnAddMinus = findViewById<Button>(R.id.btnAddMinus)

        btnAddMore.setOnClickListener {
            labelCant = findViewById(R.id.labelCant)
            val currentValue  = labelCant.text.toString().toIntOrNull()
            val newValue = currentValue?.plus(1)
            labelCant.text = newValue.toString()
        }

        btnAddMinus.setOnClickListener {
            labelCant = findViewById(R.id.labelCant)
            val currentValue = labelCant.text.toString().toIntOrNull()
            val newValue = currentValue?.minus(1)
            if (newValue != null && newValue > 0) {
                labelCant.text = newValue.toString()
            }
        }

        // Agregar al carrito
        val btnAddToCart = findViewById<Button>(R.id.btnAddToCart)
        btnAddToCart.setOnClickListener {
            val intent = Intent(this, CestaActivity::class.java)
            startActivity(intent)
        }

        // btn cancelar
        val btnCancel = findViewById<Button>(R.id.btnCancel)
        btnCancel.setOnClickListener {
            val intent = Intent(this, CategoryActivity::class.java)
            startActivity(intent)
        }
    }
}