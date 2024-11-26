package com.example.minimarket.data.model.response

data class ClienteResponse(
    val idCliente: Int,
    val nombres: String,
    val apePaterno: String,
    val apeMaterno: String,
    val celular: String,
    val email: String,
    val password: String
)
