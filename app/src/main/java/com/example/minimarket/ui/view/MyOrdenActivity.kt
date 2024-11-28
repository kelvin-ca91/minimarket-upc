package com.example.minimarket.ui.view

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.minimarket.R
import com.example.minimarket.data.model.request.DetailOrden
import com.example.minimarket.data.model.request.OrderRequest
import com.example.minimarket.data.repository.OrderRepository
import com.example.minimarket.data.repository.ProductoRepository
import com.example.minimarket.ui.view.custom.CustomToolbar
import com.example.minimarket.utils.ClientManager
import com.example.minimarket.utils.ProductManager
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.properties.Delegates

class MyOrdenActivity : AppCompatActivity() {
    private lateinit var radioGroup: RadioGroup
    private lateinit var rbDelivery: RadioButton
    private lateinit var rbStorePickup: RadioButton

    private lateinit var mapImageView: ImageView
    private var orderRepository = OrderRepository()
    private var totalPrice by Delegates.notNull<Double>()
    private lateinit var tipoEnvio : String
    override fun onCreate(savedInstanceState: Bundle?) {
        supportActionBar?.hide()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_my_orden)

        val customToolbar = findViewById<CustomToolbar>(R.id.custom_toolbar)
        customToolbar.setTitle("Mi Orden")

        radioGroup = findViewById(R.id.radioGroup)
        rbDelivery = findViewById(R.id.rbDelivery)
        rbStorePickup = findViewById(R.id.rbStorePickup)
        mapImageView = findViewById(R.id.mapImageView)
        val totalPriceView = findViewById<TextView>(R.id.totalPrice)
        val listProducts = ProductManager.getProducts()
        totalPrice = listProducts.sumOf { it.price.toDouble() * it.cant.toInt() }
        totalPriceView.setText("Total a pagar: S/ "+ totalPrice)

        // Escuchar cambios en el RadioGroup
        radioGroup.setOnCheckedChangeListener { _, checkedId ->
            if (checkedId == R.id.rbDelivery) {
                tipoEnvio = "Delivery"
                // Mostrar el mapa si se selecciona "Delivery"
                mapImageView.visibility = View.VISIBLE
            } else {
                // Ocultar el mapa si se selecciona "Recoger en tienda"
                tipoEnvio = "Recoger en tienda"
                mapImageView.visibility = View.GONE
            }
        }

        val confirmOrder = findViewById<Button>(R.id.btnConfirmOrder)
        confirmOrder.setOnClickListener {

            saveOrder()

        }
    }

    private fun getDetallesFromCart(): List<DetailOrden> {
        return ProductManager.getProducts().map { productInCart ->
            DetailOrden(
                idproducto = productInCart.id,
                precio = productInCart.price.toDouble(),
                cantidad = productInCart.cant.toInt()
            )
        }
    }
    private fun saveOrder(){
        CoroutineScope(Dispatchers.IO).launch {
            try {

                val clientAuth = ClientManager.getClient()
                val newOrder = clientAuth?.let {
                    OrderRequest(
                        idcliente = it.id,
                        tipoEnvio,
                        ubicacionEntrega = "",
                        estado = true,
                        precioTotal = totalPrice,
                        detalles = getDetallesFromCart()
                    )

                }
                val resp = newOrder?.let { orderRepository.registrarOrden(it) }
                withContext(Dispatchers.Main) {
                    ProductManager.clearCart()
                    println(resp)
                    if (resp?.idorden != null) {
                        val intent = Intent(this@MyOrdenActivity, ConfirmacionActivity::class.java)
                        intent.putExtra("COD_ORDER", resp.idorden.toString())
                        startActivity(intent)
                    }
                }
            } catch (e: Exception) {
                withContext(Dispatchers.Main) {
                    println(e)
                    Toast.makeText(this@MyOrdenActivity, "Ocurrió un error", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

    }
}