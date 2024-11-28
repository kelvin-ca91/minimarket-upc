package com.example.minimarket.data.repository

import com.example.minimarket.data.api.RetrofitInstance
import com.example.minimarket.data.model.response.CategoriaResponse

class CategoriaRepository {
    private val apiService = RetrofitInstance.api

    suspend fun listCategories(): List<CategoriaResponse> {
        return apiService.ListarCategorias()
    }
}