package com.example.minimarket.adapters

import CategoryRepository
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.Interfaces.IProduct
import com.example.minimarket.R

class ProductAdapter(
    private val products: List<IProduct>,
    private val onItemClick: (IProduct) -> Unit) :
    RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {

    class ProductViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageProduct)
        val title: TextView = itemView.findViewById(R.id.titleProduct)
        val categoryTitle: TextView = itemView.findViewById(R.id.categoryTitle)
        val price: TextView = itemView.findViewById(R.id.priceProduct)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_product_by_category, parent, false)
        return ProductViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = products[position]
        val category =   CategoryRepository.findCategoryById(product.categoryId)
        holder.image.setImageResource(product.imageResId)
        holder.title.text = product.title
        holder.price.text = "S/ "+product.price.toString()
        holder.categoryTitle.text = category?.title

        holder.itemView.setOnClickListener {
            println("product=>"+product.id)
            onItemClick(product)
        }
    }

    override fun getItemCount(): Int = products.size
}
