package com.example.minimarket.ui.view
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.minimarket.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class ConfirmacionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Ocultar el ActionBar en esta actividad
        supportActionBar?.hide()

        setContentView(R.layout.activity_confirmacion)

        // Configurar el código de entrega (se puede obtener este valor dinámicamente)
        /*val codigoEntrega = "#0000123"
        val textCodigo = findViewById<TextView>(R.id.textCodigo)
        textCodigo.text = "Código para entrega $codigoEntrega"*/

        // Configurar la barra de navegación inferior
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.inflateMenu(R.menu.bottom_nav_menu)

        bottomNavigationView.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.menu_categorias -> {
                    // Acción para la opción Categorías
                    Toast.makeText(this, "Categorías seleccionadas", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.menu_cesta -> {
                    // Acción para la opción Mi cesta
                    val intent = Intent(this, CestaActivity::class.java)
                    startActivity(intent)
                    true
                }
                R.id.menu_compras -> {
                    // Acción para la opción Mis compras
                    val intent = Intent(this, MisComprasActivity::class.java)
                    startActivity(intent)
                    true
                }
                else -> false
            }
        }
    }
}