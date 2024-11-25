package com.example.minimarket.data.api

import com.example.minimarket.data.model.request.ClienteRequest
import com.example.minimarket.data.model.request.LoginRequest
import com.example.minimarket.data.model.response.ClienteResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {

    /** Cliente **/
    @POST("/user/login")
    suspend fun login(@Body loginRequest: LoginRequest): ClienteResponse

    @POST("/clientes/registrar")
    suspend fun registrarCliente(@Body clienteRequest: ClienteRequest): ClienteResponse

    /** Categoria **/

    /** Producto **/
}