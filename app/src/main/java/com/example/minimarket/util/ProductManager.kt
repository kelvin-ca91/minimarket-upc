package com.example.minimarket.utils

import com.example.minimarket.data.model.Product
object ProductManager {
    private val productList: MutableList<Product> = mutableListOf()

    fun addProduct(product: Product) {
        productList.add(product)
    }

    fun getProducts(): List<Product> {
        return productList
    }

    fun removeProduct(id: Int) {
        val index = productList.indexOfFirst { it.id == id }
        if(index >= 0) productList.removeAt(index)
    }

    fun clearCart() {
        productList.clear()
    }
}

