package com.example.productbrowserkmm.data.repository

import com.example.productbrowserkmm.data.model.ProductDto
import com.example.productbrowserkmm.data.remote.ProductApi
import com.example.productbrowserkmm.domain.model.Product
import com.example.productbrowserkmm.domain.repository.ProductRepository

class ProductRepositoryImpl(
    private val api: ProductApi
) : ProductRepository {

    override suspend fun getProducts(): List<Product> {
        val response = api.getProducts()

        // Use println for logging in commonMain
        println("API_RESPONSE: ${response}")
        return response.products.map { it.toDomain() }
    }

    override suspend fun searchProducts(query: String): List<Product> {
        return api.searchProducts(query)
            .products
            .map { it.toDomain() }
    }
}

fun ProductDto.toDomain(): Product {
    return Product(
        id = id,
        title = title,
        description = description,
        price = price,
        brand = brand,
        rating = rating,
        thumbnail = thumbnail
    )
}
