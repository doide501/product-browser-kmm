package com.example.productbrowserkmm.domain.usecase

import com.example.productbrowserkmm.data.repository.ProductRepositoryImpl
import com.example.productbrowserkmm.domain.model.Product

class GetProductsUseCase(
    private val repository: ProductRepositoryImpl
) {

    suspend operator fun invoke(): List<Product> {
        return repository.getProducts()
    }
}