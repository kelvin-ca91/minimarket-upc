package com.example.minimarket.data.repository

import com.example.minimarket.data.api.RetrofitInstance
import com.example.minimarket.data.model.response.ProductoResponse

class ProductoRepository {
    private val apiService = RetrofitInstance.api

    suspend fun listProductosByCategoria(idCategoria:Int): List<ProductoResponse> {
        println(idCategoria)
        return apiService.ListaProductosPorCategoria(idCategoria)
    }
}