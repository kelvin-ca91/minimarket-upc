package com.example.minimarket.data.model.request

data class ClienteRequest(
    val idCliente: Int?,
    val nombres: String,
    val apePaterno: String,
    val apeMaterno: String,
    val celular: String,
    val email: String,
    val password: String
)