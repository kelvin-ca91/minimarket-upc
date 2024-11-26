package com.example.minimarket.data.model

data class Compra(
    val codigo: String,       // Código único de la compra (por ejemplo, "#0000123")
    val tipoEntrega: String,  // Tipo de entrega (por ejemplo, "Delivery" o "Recogo en tienda")
    val fecha: String,        // Fecha de la compra (por ejemplo, "10/10/2024")
    val total: String,        // Total de la compra (por ejemplo, "S/ 15.00")
    val estado: String        // Estado de la compra (por ejemplo, "Pendiente de atención" o "Entregado")
)