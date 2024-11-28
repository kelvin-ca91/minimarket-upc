package com.example.minimarket.data.model.request

data class ClienteRequest(
    val idCliente: Int?,
    val nombres: String,
    val ape_paterno: String,
    val ape_materno: String,
    val celular: String,
    val email: String,
    val password: String
)