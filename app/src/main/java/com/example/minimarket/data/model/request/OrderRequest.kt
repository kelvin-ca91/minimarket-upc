package com.example.minimarket.data.model.request

data class DetailOrden (
    val idproducto: Int,
    val precio: Double,
    val cantidad: Int
)

data class OrderRequest (
    val idcliente: Int,
    val tipoEnvio: String,
    val ubicacionEntrega: String,
    val estado: Boolean,
    val precioTotal: Double,
    val detalles: List<DetailOrden>
)