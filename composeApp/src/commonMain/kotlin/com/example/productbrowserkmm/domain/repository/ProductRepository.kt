package com.example.productbrowserkmm.domain.repository

import com.example.productbrowserkmm.domain.model.Product

interface ProductRepository {

    suspend fun getProducts(): List<Product>

    suspend fun searchProducts(query: String): List<Product>
}