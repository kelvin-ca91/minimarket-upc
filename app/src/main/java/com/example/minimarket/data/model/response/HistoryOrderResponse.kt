package com.example.minimarket.data.model.response

data class historyOrderDetail (
    val idproducto: Int,
    val precio: Double,
    val cantidad: Int
)

data class HistoryOrderResponse (
    val idorden: Int,
    val fecharegistro: String,
    val tipoEnvio: String,
    val estado: Boolean,
    val precioTotal: Double,
    val detalles: List<historyOrderDetail>
)