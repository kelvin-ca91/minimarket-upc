package com.example.minimarket.ui.view

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.minimarket.R

class PrincipalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_principal)
        supportActionBar?.hide()

        val btnDetail = findViewById<Button>(R.id.btnDetalle)
        btnDetail.setOnClickListener {
            val intent = Intent(this, DetailProductActivity::class.java)
            startActivity(intent)
        }
    }
}