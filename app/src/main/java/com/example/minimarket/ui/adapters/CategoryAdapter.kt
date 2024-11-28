package com.example.minimarket.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.Interfaces.ICategory
import com.example.minimarket.R
import com.example.minimarket.data.model.response.CategoriaResponse

class CategoryAdapter(
    private val categories: List<CategoriaResponse>,
    private val onItemClick: (CategoriaResponse) -> Unit) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image: ImageView = itemView.findViewById(R.id.imageCategory)
        val title: TextView = itemView.findViewById(R.id.titleCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_category, parent, false)
        return CategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        val category = categories[position]
        holder.image.setImageResource(category.image)
        holder.title.text = category.nombre

        holder.itemView.setOnClickListener {
            onItemClick(category)
        }
    }

    override fun getItemCount(): Int = categories.size
}
