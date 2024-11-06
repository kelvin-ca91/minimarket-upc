package com.example.minimarket.Interfaces

data class IProduct(
    val id: Int,
    val categoryId: Int,
    val title: String,
    val imageResId: Int,
    val price: Double,
)
