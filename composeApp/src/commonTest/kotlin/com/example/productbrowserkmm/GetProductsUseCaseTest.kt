package com.example.productbrowserkmm

import com.example.productbrowserkmm.domain.model.Product
import com.example.productbrowserkmm.domain.repository.ProductRepository
import com.example.productbrowserkmm.domain.usecase.GetProductsUseCase
import kotlin.test.Test
import kotlin.test.assertEquals

class FakeRepository : ProductRepository {

    override suspend fun getProducts(): List<Product> {

        return listOf(
            Product(
                1,
                "iPhone",
                "Test",
                1000.0,
                "Apple",
                4.8,
                ""
            )
        )
    }

    override suspend fun searchProducts(
        query: String
    ): List<Product> {

        return emptyList()
    }
}

class GetProductsUseCaseTest {

    @Test
    fun testGetProducts() = runTest {

        val useCase =
            GetProductsUseCase(FakeRepository())

        val result = useCase()

        assertEquals(1, result.size)
    }

    private fun runTest(function: () -> Unit): Any {}
}