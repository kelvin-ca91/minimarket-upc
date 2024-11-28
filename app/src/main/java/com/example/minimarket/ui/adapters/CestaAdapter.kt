package com.example.minimarket.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.R
import com.example.minimarket.data.model.Product
import com.example.minimarket.utils.loadImage

class CestaAdapter(
    private val product: List<Product>,
    private val onDelete: (Int) -> Unit) :
    RecyclerView.Adapter<CestaAdapter.CestaViewHolder>() {

    inner class CestaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.item_image)
        val itemTitle: TextView = view.findViewById(R.id.productName)
        val itemPrice: TextView = view.findViewById(R.id.productPrice)
        val itemCant: TextView = view.findViewById(R.id.productCant)
//        val itemDeleteButton: Button = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CestaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cesta, parent, false)
        return CestaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CestaViewHolder, position: Int) {
        val product = product[position]
        holder.itemTitle.text = product.name
        holder.itemImage.loadImage(product.imageUrl)
        holder.itemPrice.text = "Precio: S/ "+product.price
        holder.itemCant.text = "Cantidad: "+ product.cant
//        holder.itemDeleteButton.setOnClickListener {
//            onDelete(position)
//        }
    }

    override fun getItemCount(): Int = product.size
}
