package com.example.minimarket
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailProductActivity : AppCompatActivity() {
    private lateinit var customToolbar: CustomToolbar
    private lateinit var labelCant:TextView
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
    }
}