package com.example.minimarket.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.R
import com.example.minimarket.model.Compra

class CompraAdapter(private val compras: List<Compra>) : RecyclerView.Adapter<CompraAdapter.CompraViewHolder>() {

    inner class CompraViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val textCodigo: TextView = view.findViewById(R.id.textCodigo)
        val textTipoEntrega: TextView = view.findViewById(R.id.textTipoEntrega)
        val textFecha: TextView = view.findViewById(R.id.textFecha)
        val textTotal: TextView = view.findViewById(R.id.textTotal)
        val textEstado: TextView = view.findViewById(R.id.textEstado)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompraViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_compra, parent, false)
        return CompraViewHolder(view)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: CompraViewHolder, position: Int) {
        val compra = compras[position]
        holder.textCodigo.text = "Código: ${compra.codigo}"
        holder.textTipoEntrega.text = compra.tipoEntrega
        holder.textFecha.text = "Fecha: ${compra.fecha}"
        holder.textTotal.text = "Total: ${compra.total}"
        holder.textEstado.text = "Estado: ${compra.estado}"

        // Cambia el fondo del ítem según el estado
        val backgroundColor = when (compra.estado) {
            "Pendiente de atención" -> R.color.white
            "Entregado" -> R.color.purple_200
            else -> R.color.teal_700
        }
        holder.itemView.setBackgroundResource(backgroundColor)
    }

    override fun getItemCount(): Int = compras.size
}