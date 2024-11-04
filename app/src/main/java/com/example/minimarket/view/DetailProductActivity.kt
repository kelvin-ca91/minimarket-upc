package com.example.minimarket.view
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.minimarket.R
import com.example.minimarket.view.custom.CustomToolbar

class DetailProductActivity : AppCompatActivity() {
    private lateinit var customToolbar: CustomToolbar
    private lateinit var labelCant: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        // Text toolbar
        customToolbar = findViewById(R.id.custom_toolbar)
        customToolbar.setTitle("Coca Cola 600ml")

        // buttons add cants
        val btnAddMore = findViewById<Button>(R.id.btnAddMore)
        val btnAddMinus = findViewById<Button>(R.id.btnAddMinus)

        btnAddMore.setOnClickListener {
            labelCant = findViewById(R.id.labelCant)
            val currentValue  = labelCant.text.toString().toIntOrNull()
            val newValue = currentValue?.plus(1)
            labelCant.setText( newValue.toString() )
        }

        btnAddMinus.setOnClickListener {
            labelCant = findViewById(R.id.labelCant)
            val currentValue = labelCant.text.toString().toIntOrNull()
            val newValue = currentValue?.minus(1)
            if (newValue != null && newValue > 0) {
                labelCant.setText(newValue.toString())
            }
        }

        // Agregar al carrito
        val btnAddToCart = findViewById<Button>(R.id.btnAddToCart)
        btnAddToCart.setOnClickListener {
            val intent = Intent(this, CestaActivity::class.java)
            startActivity(intent)
        }
    }
}