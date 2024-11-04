package com.example.minimarket.view
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.minimarket.databinding.ActivityDetailProductBinding

class DetailProductActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailProductBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        binding = ActivityDetailProductBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Text toolbar
        binding.customToolbar.setTitle("Coca Cola 600ml")
    }

}