package com.example.minimarket.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.R
import com.example.minimarket.data.model.response.ProductoResponse

class ProductAdapter(
    private val products: List<ProductoResponse>,
    private val onItemClick: (ProductoResponse) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageProduct)
        val title: TextView = itemView.findViewById(R.id.titleProduct)
        val price: TextView = itemView.findViewById(R.id.priceProduct)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_by_category, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        holder.image.setImageResource(product.imagen.toIntOrNull()?:0)
        holder.title.text = product.nombre
        holder.price.text = "S/ "+product.precio.toString()

        holder.itemView.setOnClickListener {
            onItemClick(product)
        }
    }

    override fun getItemCount(): Int = products.size
}
