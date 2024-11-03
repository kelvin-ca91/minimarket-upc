package com.example.minimarket
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class DetailProductActivity : AppCompatActivity() {
    private lateinit var customToolbar: CustomToolbar
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        // Text toolbar
        customToolbar = findViewById(R.id.custom_toolbar)
        customToolbar.setTitle("Coca Cola 600ml")
    }

}