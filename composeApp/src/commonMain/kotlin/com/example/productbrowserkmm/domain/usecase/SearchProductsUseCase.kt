package com.example.productbrowserkmm.domain.usecase

import com.example.productbrowserkmm.data.repository.ProductRepositoryImpl
import com.example.productbrowserkmm.domain.model.Product

class SearchProductsUseCase(
    private val repository: ProductRepositoryImpl
) {

    suspend operator fun invoke(
        query: String
    ): List<Product> {

        return repository.searchProducts(query)
    }
}