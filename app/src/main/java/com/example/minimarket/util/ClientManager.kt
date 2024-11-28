package com.example.minimarket.utils

import com.example.minimarket.data.model.Client
object ClientManager {
    private var clientAuth: Client ? = null

    fun setClient(client: Client) {
        clientAuth = client
    }

    fun getClient(): Client? {
        return clientAuth
    }
}

