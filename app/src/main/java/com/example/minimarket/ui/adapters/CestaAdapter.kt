package com.example.minimarket.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.R

class CestaAdapter(private val items: MutableList<String>, private val onDelete: (Int) -> Unit) :
    RecyclerView.Adapter<CestaAdapter.CestaViewHolder>() {

    inner class CestaViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: ImageView = view.findViewById(R.id.item_image)
        val itemTitle: TextView = view.findViewById(R.id.productName)
//        val itemDeleteButton: Button = view.findViewById(R.id.btnDelete)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CestaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cesta, parent, false)
        return CestaViewHolder(view)
    }

    override fun onBindViewHolder(holder: CestaViewHolder, position: Int) {
        holder.itemTitle.text = items[position]
//        holder.itemDeleteButton.setOnClickListener {
//            onDelete(position)
//        }
    }

    override fun getItemCount(): Int = items.size
}
