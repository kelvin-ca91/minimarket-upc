package com.example.minimarket.data.model.response

import com.google.gson.annotations.SerializedName

data class ClienteResponse(
    @SerializedName("idcliente") val idCliente: Int,
    val nombres: String,
    val ape_paterno: String,
    val ape_materno: String,
    val celular: String,
    val email: String,
    val password: String
)