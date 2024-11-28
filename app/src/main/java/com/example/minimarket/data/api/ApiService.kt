package com.example.minimarket.data.api

import com.example.minimarket.data.model.request.ClienteRequest
import com.example.minimarket.data.model.request.LoginRequest
import com.example.minimarket.data.model.response.CategoriaResponse
import com.example.minimarket.data.model.response.ClienteResponse
import com.example.minimarket.data.model.response.ProductoResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiService {

    /** Cliente **/
    @POST("/user/login")
    suspend fun login(@Body loginRequest: LoginRequest): ClienteResponse

    @POST("/clientes/registrar")
    suspend fun registrarCliente(@Body clienteRequest: ClienteRequest): ClienteResponse

    @GET("/categorias")
    suspend fun ListarCategorias(): List<CategoriaResponse>

    @GET("/categorias/{idCategoria}/productos")
    suspend fun ListaProductosPorCategoria(@Path("idCategoria") idCategoria: Int): List<ProductoResponse>

    /** Producto **/
}