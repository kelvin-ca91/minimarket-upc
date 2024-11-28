package com.example.minimarket.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.minimarket.R
import com.example.minimarket.data.model.response.HistoryOrderResponse

class CompraAdapter(
    private val orders: List<HistoryOrderResponse>
) : RecyclerView.Adapter<CompraAdapter.CompraViewHolder>() {

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


    override fun onBindViewHolder(holder: CompraViewHolder, position: Int) {

        val order = orders[position]
        val numeroConCeros = order.idorden.toString().padStart(7, '0')
        holder.textCodigo.text = "Código: #${numeroConCeros}"
        holder.textTipoEntrega.text = order.tipoEnvio
        holder.textFecha.text = "Fecha: ${order.fecharegistro}"
        holder.textTotal.text = "Total: S/${order.precioTotal}"
        var newEstado = "Entregado"
        if(order.estado){
            newEstado = "Pendiente"
        }
        holder.textEstado.text = "Estado: ${newEstado}"

        // Cambia el fondo del ítem según el estado
//        val backgroundColor = when (order.estado) {
//            true -> R.color.white
//            false -> R.color.teal_700
//        }
//        holder.itemView.setBackgroundResource(backgroundColor)
    }

    override fun getItemCount(): Int = orders.size
}