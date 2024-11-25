package com.example.minimarket.data.repository

import com.example.minimarket.data.api.RetrofitInstance
import com.example.minimarket.data.model.request.ClienteRequest
import com.example.minimarket.data.model.request.LoginRequest
import com.example.minimarket.data.model.response.ClienteResponse

class ClienteRepository {

    private val apiService = RetrofitInstance.api

    /**
     * Función que permite loguear un cliente
     * @param loginRequest: ClienteRequest
     * @return ClienteResponse
     */
    suspend fun loginCliente(loginRequest: LoginRequest): ClienteResponse{
        return apiService.login(loginRequest)
    }

    /**
     * Función que permite registrar un cliente
     * @param clienteRequest: ClienteRequest
     * @return ClienteResponse
     */
    suspend fun registrarCliente(clienteRequest: ClienteRequest): ClienteResponse{
        return apiService.registrarCliente(clienteRequest)
    }
}