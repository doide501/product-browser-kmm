package com.example.productbrowserkmm.data.remote

import com.example.productbrowserkmm.data.model.ProductDto
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get

class ProductApi(
    private val client: HttpClient
) {

    suspend fun getProducts(): ProductsResponse {

        return client.get("https://dummyjson.com/products")
            .body()
    }

    suspend fun searchProducts(query: String): ProductsResponse {

        return client.get("https://dummyjson.com/products/search?q=$query")
            .body()
    }
}