package com.example.minimarket.data.repository

import com.example.minimarket.data.api.RetrofitInstance
import com.example.minimarket.data.model.request.OrderRequest
import com.example.minimarket.data.model.response.OrderResponse

class OrderRepository {
    private val apiService = RetrofitInstance.api

    suspend fun registrarOrden(order: OrderRequest): OrderResponse {
        return apiService.registrarOrden(order)
    }
}